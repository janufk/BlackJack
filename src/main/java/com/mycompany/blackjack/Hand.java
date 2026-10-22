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
import java.util.List;


public class Hand {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    // ace is originally 11, but it becomes 1 if the score would be above 21.
    public int getTotal() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getBlackjackValue();

            if (card.getValue() == 1) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }
}
