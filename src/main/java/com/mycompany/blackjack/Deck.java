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

public final class Deck {

    private final List<Card> cards = new ArrayList<>();
    private int nextCard;

    public Deck() {
        createDeck();
        shuffle();
    }

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

    public void shuffle() {
        Collections.shuffle(cards);
        nextCard = 0;
    }


    public Card drawCard() {
        return cards.get(nextCard++);
    }
}
