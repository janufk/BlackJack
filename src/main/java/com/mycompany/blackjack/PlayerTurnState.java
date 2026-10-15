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

public class PlayerTurnState implements GameState {

    @Override
    public void hit(BlackjackGame game) {
        game.drawPlayerCard();

        if (game.getPlayerTotal() >= 21) {
            if (game.getPlayerTotal() > 21) {
                game.revealDealer();
                game.setState(new GameOverState());
            } else {
                //At 21, the player's turn ends and the dealer's cards will be revealed
                stand(game);
            }
        }
    }

    @Override
    public void stand(BlackjackGame game) {
        game.revealDealer();
        game.setState(new DealerTurnState());
        game.stand();
    }
}
