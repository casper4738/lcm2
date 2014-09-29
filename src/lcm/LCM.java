/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcm;

/**
 *
 * @author casper
 */
public class LCM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LCM main = new LCM();
        main.setA(1);
        main.setC(7);
        main.setM(38);

        int[] cek = new int[38];

        for (int i = 0; i < 38; i++) {
            cek[i] = -1;
        }

        int z = 21;
        for (int i = 0; i < 38; i++) {
            cek[i] = z;
            z = main.getLinearCongruen(z);
            System.out.println((i + 1) + ":" + z);
        }
        
        System.out.println("-----------------------------\n\n\n");
        for (int i = 0; i < 38; i++) {
            for (int j = i+1; j < 38; j++) {
                if(cek[i] == cek[j]) {
                    System.out.println("salah : "+cek[i]);
                }
            }
        }
        
//        main.rule2();
    }

    public int getLinearCongruen(int z) {
        return ((a * z) + c) % m;
    }

    private int c;
    private int m;
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setM(int m) {
        this.m = m;
    }

}
