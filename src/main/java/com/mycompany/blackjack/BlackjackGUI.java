package com.mycompany.blackjack;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author gwynerwitkamp
 * @id 2375125
 * @author janufkrishnan
 * @id 2224429
 */
public class BlackjackGUI extends javax.swing.JFrame {

    private final BlackjackGame game;
    private final BettingSystem bettingSystem;
    private final BettingController bettingController;

    private boolean betSettled = true;
    private boolean roundActive = false;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BlackjackGUI.class.getName());

    public BlackjackGUI() {
        initComponents();

        setTitle("Blackjack");
        setSize(650, 700);
        setLocationRelativeTo(null);

        bettingSystem = new BettingSystem();
        bettingController = new BettingController(bettingSystem);
        game = new BlackjackGame();

        game.newGame();

        if (bettingController.requestBet(this)) {
            roundActive = true;
            betSettled = false;
        }

        updateGUI();
    }

    private String cardsHTML(
            java.util.List<Card> cards,
            boolean hideSecondCard) {

        StringBuilder html = new StringBuilder();

        for (int i = 0; i < cards.size(); i++) {
            if (hideSecondCard && i == 1) {
                html.append("<img src='")
                        .append(getClass().getResource("/images/card_down.jpg"))
                        .append("' width='75' height='110'> ");
            } else {
                Card card = cards.get(i);

                String filename = card.getImageFilename();
                java.net.URL imageUrl
                        = getClass().getResource("/images/" + filename);

                html.append("<img src='")
                        .append(imageUrl)
                        .append("' width='75' height='110'> ");
            }
        }
        return html.toString();
    }

    private void updateGUI() {

        // Shows dealercards when round is finished.
        if (game.isGameOver()) {
            game.revealDealer();
        }

        boolean hideCard = !game.isDealerRevealed();

        jLabel1.setText(
                "<html>Dealer: "
                + cardsHTML(game.getDealerCards(), hideCard)
                + (hideCard ? "" : " (" + game.getDealerTotal() + ")")
                + "</html>"
        );

        jLabel2.setText(
                "<html>Player: "
                + cardsHTML(game.getPlayerCards(), false)
                + " (" + game.getPlayerTotal() + ")"
                + "</html>"
        );

        if (roundActive && game.isGameOver() && !betSettled) {

            int playerTotal = game.getPlayerTotal();
            int dealerTotal = game.getDealerTotal();

            String result;

            if (playerTotal > 21) {
                result = "lose";
            } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
                result = "win";
            } else if (playerTotal < dealerTotal) {
                result = "lose";
            } else {
                result = "draw";
            }

            bettingController.settleBet(result);
            betSettled = true;

            // Shows the result on the screen.
            String resultText;

            switch (result) {
                case "win" ->
                    resultText = " - You win!";
                case "lose" ->
                    resultText = " - You lose.";
                default ->
                    resultText = " - Draw!";
            }

            jLabel2.setText(
                    jLabel2.getText().replace("</html>", resultText + "</html>")
            );

            // Checks if the player still has any balance.
            if (bettingSystem.getBalance() <= 0) {
                roundActive = false;

                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);

                JOptionPane.showMessageDialog(
                        this,
                        "GAME OVER!\nYou are out of money!",
                        "Game Over",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

        }

        // Buttons hit and stand are only active during a game.
        // New game button is only active during no game.
        jButton1.setEnabled(roundActive && !game.isGameOver());
        jButton2.setEnabled(roundActive && !game.isGameOver());
        jButton3.setEnabled(!roundActive || game.isGameOver());

        setTitle(
                "Balance: " + bettingSystem.getBalance()
                + " Current bet: " + bettingSystem.getCurrentBet()
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dealer's hand");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player's hand");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jButton1.setText("Hit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Stand");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("NewGame");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton1)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3)
                        .addGap(0, 129, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!bettingController.requestBet(this)) {
            return;
        }

        game.newGame();
        roundActive = true;
        betSettled = false;

        updateGUI();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        game.stand();
        updateGUI();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        game.hit();
        updateGUI();

    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BlackjackGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
