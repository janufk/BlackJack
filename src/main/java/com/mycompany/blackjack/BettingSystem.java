/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;

/**
 *
 * @author 20253182
 */
public class BettingSystem {

    private int balance;
    private int currentBet;

    public BettingSystem() {
        balance = 1000;
        currentBet = 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public boolean placeBet(int amount) {
        if (amount <= 0 || amount > balance || currentBet != 0) {
            return false;
        }

        currentBet = amount;
        balance -= amount;

        return true;
    }

    public void win() {
        balance += currentBet * 2;
        currentBet = 0;
    }

    public void lose() {
        currentBet = 0;
    }

    public void draw() {
        balance += currentBet;
        currentBet = 0;
    }

    public boolean canBet() {
        return balance > 0 && currentBet == 0;
    }
}
