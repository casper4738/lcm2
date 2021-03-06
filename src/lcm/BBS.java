package lcm;
 
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
/**
 *
 * @author casper
 */
public class BBS {

    public static void main(String[] args) throws InterruptedException {

        BBS bbs = new BBS();
        bbs.setP(BigInteger.valueOf(30));
        bbs.setQ(BigInteger.valueOf(34));
        bbs.run();
        int[] listRandom = bbs.getListRandom();
        for (int i : listRandom) {
            System.out.println(i);
        }

    }

    private static final int BIT = 6;
    private int[] listRandom;
    private BigInteger p;
    private BigInteger q;
    private long timeDuration;

    public BBS() {
        this.listRandom = new int[38];
    }

    public void run() {
        long long1 = System.nanoTime();
        boolean bool = true;
        BigInteger new_p = p;
        BigInteger new_q = q;
        while (new_p.compareTo(BigInteger.valueOf(100)) <= 0) {
            new_q = q;
            while (new_q.compareTo(BigInteger.valueOf(100)) <= 0 && bool) {
                for (int k = 5; k < 100; k++) {
                    BigInteger s = BigInteger.valueOf(k);
                    if (generatorBBS(s, new_p, new_q)) {
                        int[] cek = getListRandom();
                        while (!sisip(cek)) {
                        }
                        p = new_p;
                        q = new_q;
                        bool = false;
                        break;
                    }
                }
                new_q = new_q.add(BigInteger.ONE);
            }
            new_p = new_p.add(BigInteger.ONE);
        }
        long long2 = System.nanoTime();
        timeDuration = TimeUnit.MILLISECONDS.convert(long2 - long1, TimeUnit.NANOSECONDS);
        System.out.println("value : " + timeDuration);
    }

    private boolean sisip(int[] cek) {
        boolean[] bool = new boolean[cek.length];
        for (int i = 0; i < cek.length; i++) {
            bool[i] = false;
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = 0; j < cek.length; j++) {
                if (cek[j] == i) {
                    bool[i] = true;
                }
            }
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = i + 1; j < cek.length; j++) {
                if (cek[i] == cek[j]) {
                    for (int n = 0; n < cek.length; n++) {
                        if (!bool[n]) {
                            cek[j] = n;
                            bool[n] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = i + 1; j < cek.length; j++) {
                if (cek[i] == cek[j]) {
                    break;
                }
            }
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = i + 1; j < cek.length; j++) {
                if (cek[i] == cek[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getListRandom() {
        return listRandom;
    }

    public boolean isBilanganPrima(BigInteger p, BigInteger q) {
        if (p.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) != 0) {
            return false;
        }
        return q.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) == 0;
    }

    private BigInteger getBilanganBlum(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    private boolean isSeed(BigInteger s, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        return s.compareTo(BigInteger.valueOf(2)) >= 0 && s.compareTo(n) < 0;
    }

    private boolean isGreatestCommonDivisor(BigInteger s, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        List<BigInteger> list = new ArrayList();

        BigInteger i = BigInteger.valueOf(2);
        while (i.compareTo(s) <= 0) {
            double result = (s.doubleValue() / (double) i.doubleValue()) % 1;
            if (result == 0) {
                list.add(i);
            }
            i = i.add(BigInteger.valueOf(1));
        }

        for (BigInteger e : list) {
            if (n.mod(e).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean generatorBBS(BigInteger s, BigInteger p, BigInteger q) {
        if (!isBilanganPrima(p, q)) {
//            System.out.println("tidak penuhi syarat bilangan 3 mod 4");
            return false;
        } else if (!isSeed(s, p, q)) {
//            System.out.println("tidak penuhi syarat 2 <= s < n ");
            return false;
        } else if (!isGreatestCommonDivisor(s, p, q)) {
//            System.out.println("tidak penuhi syarat relatif bilangan prima GCD = 1");
            return false;
        } else {
//            System.out.println("memenuhi syarat");
            BigInteger n = getBilanganBlum(p, q);
            BigInteger x = (s.multiply(s)).mod(n);
            int ite = 0;
            int maxIte = 0;
            while (maxIte <= 50) {
                x = (x.multiply(x)).mod(n);
                BigInteger value = getLSBInDec(x);
                if (ite < listRandom.length && value.intValue() <= listRandom.length) {
                    listRandom[ite] = value.intValue();
                    ite++;
                }
                maxIte++;
            }
            return true;
        }
    }

    public BigInteger getLSBInDec(BigInteger value) {
        List<BigInteger> list = convertToBin(value);
        String string = "";
        if (list.size() < BIT) {
            for (int i = list.size() - 1; i >= 0; i--) {
                string = string + list.get(list.size() - 1 - i);
            }
        } else {
            for (int i = BIT - 1; i >= 0; i--) {
                string = string + list.get(list.size() - 1 - i);
            }
        }
        return convertToDec(string);
    }

    private List<BigInteger> convertToBin(BigInteger value) {
        List<BigInteger> vlist = new ArrayList<>();
        BigInteger ve = value;
        while (ve.compareTo(BigInteger.valueOf(0)) == 1) {
            vlist.add(ve.mod(BigInteger.valueOf(2)));
            ve = ve.divide(BigInteger.valueOf(2));
        }

        List<BigInteger> list = new ArrayList<>();
        for (int i = vlist.size() - 1; i >= 0; i--) {
            list.add(vlist.get(i));
        }

        return list;
    }

    private BigInteger convertToDec(String value) {
        BigInteger dec = BigInteger.valueOf(0);
        int u = 0;
        for (int j = value.length() - 1; j >= 0; j--) {
            BigInteger z = BigInteger.valueOf(Integer.valueOf(value.charAt(u) + ""));
            int k = (int) Math.pow(2, j);
            u++;
            dec = dec.add(z.multiply(BigInteger.valueOf(k)));
        }
        return dec;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public long getTimeDuration() {
        return timeDuration;
    }

}
