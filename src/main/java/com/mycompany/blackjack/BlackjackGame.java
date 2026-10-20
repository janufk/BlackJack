package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20253182
 */


//hoi
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BlackjackGame {

    private final Random rand = new Random();

    private final List<Integer> playerCards = new ArrayList<>();
    private final List<Integer> dealerCards = new ArrayList<>();

    private final List<String> playerSuits = new ArrayList<>();
    private final List<String> dealerSuits = new ArrayList<>();

    private final List<Integer> deckValues = new ArrayList<>();
    private final List<String> deckSuits = new ArrayList<>();

    private int nextCard;
    private GameState state;
    private boolean dealerRevealed;

    public BlackjackGame() {
        newGame();
    }

    public void newGame() {
        playerCards.clear();
        dealerCards.clear();
        playerSuits.clear();
        dealerSuits.clear();

        deckValues.clear();
        deckSuits.clear();

        String[] suits = {
            "clubs", "diamonds", "hearts", "spades"
        };

        // Maak een standaard kaartspel van 52 unieke kaarten.
        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                deckValues.add(value);
                deckSuits.add(suit);
            }
        }

        // Schud het kaartspel.
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            order.add(i);
        }
        Collections.shuffle(order, rand);

        List<Integer> shuffledValues = new ArrayList<>();
        List<String> shuffledSuits = new ArrayList<>();

        for (int index : order) {
            shuffledValues.add(deckValues.get(index));
            shuffledSuits.add(deckSuits.get(index));
        }

        deckValues.clear();
        deckValues.addAll(shuffledValues);

        deckSuits.clear();
        deckSuits.addAll(shuffledSuits);

        nextCard = 0;
        dealerRevealed = false;
        state = new PlayerTurnState();

        // Beginhand: twee kaarten per speler.
        drawPlayerCard();
        drawDealerCard();
        drawPlayerCard();
        drawDealerCard();
    }

    private int drawCard() {
        if (nextCard >= deckValues.size()) {
            throw new IllegalStateException(
                "Er zijn geen kaarten meer."
            );
        }

        return nextCard++;
    }

    public void hit() {
        state.hit(this);
    }

    public void stand() {
        state.stand(this);
    }

    public void drawPlayerCard() {
        int index = drawCard();
        playerCards.add(deckValues.get(index));
        playerSuits.add(deckSuits.get(index));
    }

    public void drawDealerCard() {
        int index = drawCard();
        dealerCards.add(deckValues.get(index));
        dealerSuits.add(deckSuits.get(index));
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

    public List<String> getPlayerSuits() {
        return new ArrayList<>(playerSuits);
    }

    public List<String> getDealerSuits() {
        return new ArrayList<>(dealerSuits);
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

