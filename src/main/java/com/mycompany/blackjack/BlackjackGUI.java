package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 20253182
 */

public class BlackjackGUI extends javax.swing.JFrame {

private BlackjackGame game;


private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BlackjackGUI.class.getName());
    /**
     * Creates new form BlackjackGUI
     */
    public BlackjackGUI() {
        initComponents();
        setTitle("Blackjack");
        setSize(650, 700);
        
        
        game = new BlackjackGame();
        updateGUI();
    }

private String cardName(int card) {
    switch (card) {
        case 1: return "Aas";
        case 11: return "Boer";
        case 12: return "Vrouw";
        case 13: return "Heer";
        default: return String.valueOf(card);
    }
}

private String getCardFilename(int value, String suit) {
    String rank;

    switch (value) {
        case 1:
            rank = "ace";
            break;
        case 11:
            rank = "jack";
            break;
        case 12:
            rank = "queen";
            break;
        case 13:
            rank = "king";
            break;
        default:
            rank = String.valueOf(value);
    }

    String filename = rank + "_of_" + suit;

    // De afbeeldingsbestanden van de plaatkaarten
    // hebben in jouw map vaak een 2 achter de naam.
    if (value >= 11) {
        filename += "2";
    }

    return filename + ".png";
}



private String cardImage(int value, String suit) {
    String filename = getCardFilename(value, suit);

    java.net.URL url =
        getClass().getResource("/images/" + filename);

    if (url == null) {
        return "<span>Kaart ontbreekt</span>";
    }

    return "<img src='" + url.toExternalForm()
        + "' width='120' height='160'>";
}


private String cardsHTML(
        java.util.List<Integer> cards,
        java.util.List<String> suits,
        boolean hideSecondCard) {

    StringBuilder html = new StringBuilder(
        "<html><div style='white-space:nowrap'>"
    );

    for (int i = 0; i < cards.size(); i++) {
        if (i > 0) {
            html.append("&nbsp;&nbsp;");
        }

        if (hideSecondCard && i == 1) {
            java.net.URL url =
                getClass().getResource("/images/card_down.jpg");

            if (url != null) {
                html.append("<img src='")
                    .append(url.toExternalForm())
                    .append("' width='120' height='160'>");
            } else {
                html.append("[Verborgen kaart]");
            }
        } else {
            html.append(cardImage(cards.get(i), suits.get(i)));
        }
    }

    html.append("</div></html>");
    return html.toString();
}




private String formatCards(java.util.List<Integer> cards,
                           boolean hideSecondCard) {
    StringBuilder result = new StringBuilder("[");

    for (int i = 0; i < cards.size(); i++) {
        if (i > 0) {
            result.append(", ");
        }

        if (hideSecondCard && i == 1) {
            result.append("?");
        } else {
            result.append(cardName(cards.get(i)));
        }
    }

    result.append("]");
    return result.toString();
}


    private void updateGUI() {
    boolean hideCard = !game.isDealerRevealed();

    jLabel1.setText(
        "<html>Dealer: "
        + cardsHTML(
            game.getDealerCards(),
            game.getDealerSuits(),
            hideCard
        ).replace("<html>", "").replace("</html>", "")
        + (hideCard
            ? ""
            : " (" + game.getDealerTotal() + ")")
        + "</html>"
    );

    jLabel2.setText(
        "<html>Player: "
        + cardsHTML(
            game.getPlayerCards(),
            game.getPlayerSuits(),
            false
        ).replace("<html>", "").replace("</html>", "")
        + " (" + game.getPlayerTotal() + ")"
        + "</html>"
    );

    if (game.isGameOver()) {
        if (game.getPlayerTotal() > 21) {
            jLabel2.setText(
                jLabel2.getText().replace(
                    "</html>", " - Bust! Je verliest.</html>"
                )
            );
        } else if (game.getDealerTotal() > 21
                || game.getPlayerTotal() > game.getDealerTotal()) {
            jLabel2.setText(
                jLabel2.getText().replace(
                    "</html>", " - Je wint!</html>"
                )
            );
        } else if (game.getPlayerTotal() < game.getDealerTotal()) {
            jLabel2.setText(
                jLabel2.getText().replace(
                    "</html>", " - Dealer wint.</html>"
                )
            );
        } else {
            jLabel2.setText(
                jLabel2.getText().replace(
                    "</html>", " - Gelijkspel.</html>"
                )
            );
        }
    }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        game.hit();
        updateGUI();
    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        game.newGame();
        updateGUI();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        game.stand(); 
        updateGUI();
   

    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
