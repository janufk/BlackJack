package com.mycompany.blackjack;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20253182
 */




public class PlayerTurnState implements GameState {

    @Override
    public void hit(BlackjackGame game) {
        // De speler trekt een kaart.
        game.drawPlayerCard();

        // Als de speler meer dan 21 punten heeft, is het spel voorbij.
        if (game.getPlayerTotal() > 21) {
            game.revealDealer();
            game.setState(new GameOverState());
        }
    }

    @Override
    public void stand(BlackjackGame game) {
        // De speler stopt. Nu is de dealer aan de beurt.
        game.setState(new DealerTurnState());
    }
}

