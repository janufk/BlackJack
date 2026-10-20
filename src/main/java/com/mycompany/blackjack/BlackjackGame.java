package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20253182
 */





/**
 * Beheert een Blackjack-ronde.
 * Het deck deelt kaarten uit, de handen bewaren ze
 * en de GameState bepaalt welke acties toegestaan zijn.
 */
public class BlackjackGame {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    private GameState state;
    private boolean dealerRevealed;

public BlackjackGame() {
    newGame();
    }

    /**
     * Start een nieuwe ronde met een nieuw geschud deck.
     */
    public void newGame() {
        deck = new Deck();

        playerHand = new Hand();
        dealerHand = new Hand();

        dealerRevealed = false;
        state = new PlayerTurnState();

        // Deel twee kaarten aan iedere hand.
        drawPlayerCard();
        drawDealerCard();
        drawPlayerCard();
        drawDealerCard();
    }

    public void hit() {
        state.hit(this);
    }

    
public void stand() {
    state.stand(this);

    if (state instanceof DealerTurnState dealerTurnState) {
            dealerTurnState.playDealerTurn(this);
    }
}


    public void drawPlayerCard() {
        playerHand.addCard(deck.drawCard());
    }

    public void drawDealerCard() {
        dealerHand.addCard(deck.drawCard());
    }
    public int getPlayerTotal() {
        return playerHand.getTotal();
    }

    public int getDealerTotal() {
        return dealerHand.getTotal();
    }


    public java.util.List<Card> getPlayerCards() {
        return playerHand.getCards();
    }

    public java.util.List<Card> getDealerCards() {
        return dealerHand.getCards();
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
