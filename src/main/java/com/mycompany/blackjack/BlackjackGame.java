package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20253182
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackjackGame {

    private final Random rand = new Random();

    private final List<Integer> playerCards = new ArrayList<>();
    private final List<Integer> dealerCards = new ArrayList<>();

    private GameState state;
    private boolean dealerRevealed;

    public BlackjackGame() {
        newGame();
    }

    public void newGame() {
        playerCards.clear();
        dealerCards.clear();
        dealerRevealed = false;

        // Deel twee kaarten aan iedere speler
        playerCards.add(drawCard());
        dealerCards.add(drawCard());
        playerCards.add(drawCard());
        dealerCards.add(drawCard());

        state = new PlayerTurnState();
    }

    private int drawCard() {
        // 1 = aas, 11 = boer, 12 = vrouw, 13 = heer
        return rand.nextInt(13) + 1;
    }

    public void hit() {
        state.hit(this);
    }

    public void stand() {
        state.stand(this);
    }

    public void drawPlayerCard() {
        playerCards.add(drawCard());
    }

    public void drawDealerCard() {
        dealerCards.add(drawCard());
    }

    public int getPlayerTotal() {
        return calculateTotal(playerCards);
    }

    public int getDealerTotal() {
        return calculateTotal(dealerCards);
    }

    private int calculateTotal(List<Integer> cards) {
        int total = 0;
        int aces = 0;

        for (int card : cards) {
            if (card == 1) {
                total += 11;
                aces++;
            } else if (card >= 11) {
                total += 10;
            } else {
                total += card;
            }
        }

        // Een aas telt als 1 als 11 bust zou veroorzaken
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public List<Integer> getPlayerCards() {
        return new ArrayList<>(playerCards);
    }

    public List<Integer> getDealerCards() {
        return new ArrayList<>(dealerCards);
    }

    public boolean isDealerRevealed() {
        return dealerRevealed;
    }

    public void revealDealer() {
        dealerRevealed = true;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public boolean isGameOver() {
        return state instanceof GameOverState;
    }
}

