/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;

/**
 *
 * @author 20253182
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Beheert één standaard kaartspel van 52 kaarten.
 */
public final class Deck {

    private final List<Card> cards = new ArrayList<>();
    private int nextCard;

    public Deck() {
        createDeck();
        shuffle();
    }

    /**
     * Maakt 13 waarden voor elk van de vier soorten.
     */
    private void createDeck() {
        String[] suits = {
            "clubs", "diamonds", "hearts", "spades"
        };

        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                cards.add(new Card(value, suit));
            }
        }
    }

    /**
     * Schudt de kaarten en zet de positie terug op nul.
     */
    public void shuffle() {
        Collections.shuffle(cards);
        nextCard = 0;
    }

    /**
     * Geeft de volgende kaart uit het geschudde kaartspel.
     * @return 
     */
    public Card drawCard() {
        if (nextCard >= cards.size()) {
            throw new IllegalStateException(
                "Er zijn geen kaarten meer."
            );
        }

        return cards.get(nextCard++);
    }
}

