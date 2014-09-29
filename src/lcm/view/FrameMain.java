/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JButton;
import lcm.Plate;
import lcm.User;

/**
 *
 * @author casper
 */
public class FrameMain extends javax.swing.JFrame {

    /**
     * Creates new form FrameMain
     */
    private PanelIntroduction panelIntroduction;
    private PanelIshiharaTest panelIshiharaTest;
    private PanelTestResult panelTestResult;
    private PanelIdentity panelIdentity;
    private PanelDataUser panelDataUser;
    public static User USER;

    public FrameMain() {
        initComponents();
        new java.io.File("result").mkdirs();
        USER = new User();

        setTitle("APLIKASI TES BUTA WARNA MENGGUNAKAN LCM");

        panelIntroduction = new PanelIntroduction(this);
        panelIshiharaTest = new PanelIshiharaTest(this);
        panelTestResult = new PanelTestResult(this);
        panelIdentity = new PanelIdentity(this);
        panelDataUser = new PanelDataUser(this);
        
        panelIntroduction.setOpaque(false);
        panelIshiharaTest.setOpaque(false);
        panelTestResult.setOpaque(false);
        panelIdentity.setOpaque(false);
        panelDataUser.setOpaque(false);

        panelMain.add(panelIntroduction, "card1");
        panelMain.add(panelIshiharaTest, "card2");
        panelMain.add(panelTestResult, "card3");

        jPanel1.add(panelIdentity, "card1");
        jPanel1.add(panelTest, "card2");
        jPanel1.add(panelDataUser, "card3");

        setResizable(false);
        setLocationRelativeTo(null);
        buttonTestResult.setEnabled(false);
        buttonIshiharaTest.setEnabled(false);
    }
    
    public void showPanelIdentity() {
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "card1");
    }
    
    public void showPanelTest() {
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "card2");
    }
    
    public void showPanelUser() {
        panelDataUser.setData();
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "card3");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iPanelBg1 = new lcm.component.IPanelBg();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelTest = new javax.swing.JPanel();
        panelMain = new lcm.component.IPanelGlass();
        jPanel2 = new javax.swing.JPanel();
        buttonIntroduction = new javax.swing.JButton();
        buttonIshiharaTest = new javax.swing.JButton();
        buttonTestResult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iPanelBg1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Batang", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TES BUTA WARNA");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tes Ishihara");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iPanelBg1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.CardLayout());

        panelTest.setOpaque(false);

        panelMain.setLayout(new java.awt.CardLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        buttonIntroduction.setText("Pengenalan");
        buttonIntroduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIntroductionActionPerformed(evt);
            }
        });
        jPanel2.add(buttonIntroduction);

        buttonIshiharaTest.setText("Tes Ishihara ");
        buttonIshiharaTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIshiharaTestActionPerformed(evt);
            }
        });
        jPanel2.add(buttonIshiharaTest);

        buttonTestResult.setText("Hasil Tes");
        buttonTestResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTestResultActionPerformed(evt);
            }
        });
        jPanel2.add(buttonTestResult);

        javax.swing.GroupLayout panelTestLayout = new javax.swing.GroupLayout(panelTest);
        panelTest.setLayout(panelTestLayout);
        panelTestLayout.setHorizontalGroup(
            panelTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelTestLayout.setVerticalGroup(
            panelTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelTest, "card2");

        iPanelBg1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(iPanelBg1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTestResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTestResultActionPerformed
        showResult();
    }//GEN-LAST:event_buttonTestResultActionPerformed

    private void buttonIshiharaTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIshiharaTestActionPerformed
        showCard("card2");
    }//GEN-LAST:event_buttonIshiharaTestActionPerformed

    private void buttonIntroductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIntroductionActionPerformed
        showCard("card1");
    }//GEN-LAST:event_buttonIntroductionActionPerformed

    public void showResult() {
        showCard("card3");
        panelTestResult.set(getListPlates());
        buttonTestResult.setEnabled(true);
    }
    
    public void restartTest() {
        panelIshiharaTest.stopTimer();
        buttonIshiharaTest.setEnabled(false);
        buttonTestResult.setEnabled(false);
    }
    
    public void startTest() {
        panelIshiharaTest.reset();
        panelIshiharaTest.startTimer();
        buttonIshiharaTest.setEnabled(false);
        buttonTestResult.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIntroduction;
    private javax.swing.JButton buttonIshiharaTest;
    private javax.swing.JButton buttonTestResult;
    private lcm.component.IPanelBg iPanelBg1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private lcm.component.IPanelGlass panelMain;
    private javax.swing.JPanel panelTest;
    // End of variables declaration//GEN-END:variables

    public List<Plate> getListPlates() {
        return panelIshiharaTest.getListPlates();
    }

    public void showCard(String card) {
        ((CardLayout) panelMain.getLayout()).show(panelMain, card);
    }

    public JButton getButtonIshiharaTest() {
        return buttonIshiharaTest;
    }

}
