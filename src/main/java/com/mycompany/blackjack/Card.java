/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;

/**
 *
 * @author 20253182
 */

public class Card {

    private final int value;
    private final String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }


    public int getBlackjackValue() {
        if (value == 1) {
            return 11;
        }

        if (value >= 11) {
            return 10;
        }

        return value;
    }


    public String getImageFilename() {
        String rank;

        rank = switch (value) {
            case 1 ->
                "ace";
            case 11 ->
                "jack";
            case 12 ->
                "queen";
            case 13 ->
                "king";
            default ->
                String.valueOf(value);
        };
        String filename = rank + "_of_" + suit;
        if(value >= 11) {
            filename += "2";
        }
        return filename + ".png";
    }

}
