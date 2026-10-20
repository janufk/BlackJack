/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;

import javax.swing.JFrame;

public class BettingController {

    private final BettingSystem bettingSystem;

    public BettingController(BettingSystem bettingSystem) {
        this.bettingSystem = bettingSystem;
    }

    public BettingSystem getBettingSystem() {
        return bettingSystem;
    }

    public boolean requestBet(JFrame parent) {
        if (!bettingSystem.canBet()) {
            return false;
        }

        BettingDialog dialog = new BettingDialog(parent, bettingSystem);
        int amount = dialog.showDialog();

        if (amount <= 0) {
            return false;
        }

        return bettingSystem.placeBet(amount);
    }

    public void settleBet(String result) {
        switch (result) {
            case "win" ->
                bettingSystem.win();

            case "lose" ->
                bettingSystem.lose();

            case "draw" ->
                bettingSystem.draw();
        }
    }
}
