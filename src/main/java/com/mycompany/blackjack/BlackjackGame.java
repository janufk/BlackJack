package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2375125
 * @author 2224429
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackjackGame {

    //Mixes up the cards
    private final Random rand = new Random();

    //Cards value of the player and dealer
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

        //Draw two cards to both the player and the dealer
        playerCards.add(drawCard());
        dealerCards.add(drawCard());
        playerCards.add(drawCard());
        dealerCards.add(drawCard());

        state = new PlayerTurnState();
    }

    private int drawCard() {
        // 1 = ace, 11 = jack, 12 = queen, 13 = king
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
                total = total + 11;
                aces = aces + 1;
            } else if (card >= 11) {
                total = total + 10;
            } else {
                total = total + card;
            }
        }

        //Ace has value 1 if value 11 will lead to a bust
        while (total > 21 && aces > 0) {
            total = total - 10;
            aces = aces - 1;
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

