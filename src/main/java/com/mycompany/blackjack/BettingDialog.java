/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gwynerwitkamp
 * @id 2375125
 * @author janufkrishnan
 * @id 2224429
 */
package com.mycompany.blackjack;

import javax.swing.*;
import java.awt.*;

public class BettingDialog extends JDialog {

    private final BettingSystem bettingSystem;
    private final JTextField betField;
    private int confirmedBet = 0;

    public BettingDialog(
            JFrame parent,
            BettingSystem bettingSystem) {

        super(parent, "Bettingsystem", true);

        this.bettingSystem = bettingSystem;
        this.betField = new JTextField(10);

        JLabel balanceLabel = new JLabel(
                "Balance: " + bettingSystem.getBalance()
        );

        JLabel betLabel = new JLabel("Place your bet:");

        JButton confirmButton = new JButton("Confirm");

        confirmButton.addActionListener(e -> confirmBet());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        panel.add(balanceLabel);
        panel.add(new JLabel(""));
        panel.add(betLabel);
        panel.add(betField);
        panel.add(new JLabel(""));
        panel.add(confirmButton);

        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }

    private void confirmBet() {
        try {
            int amount = Integer.parseInt(betField.getText().trim());

            if (amount <= 0 || amount > bettingSystem.getBalance()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid bet or insufficient balance."
                );
                return;
            }

            confirmedBet = amount;
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid integer."
            );
        }
    }

    public int showDialog() {
        setVisible(true);
        return confirmedBet;
    }
}
