package com.mycompany.blackjack;


import com.mycompany.blackjack.GameState;
import com.mycompany.blackjack.GameOverState;
import com.mycompany.blackjack.DealerTurnState;
import com.mycompany.blackjack.BlackjackGame;

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
        game.drawPlayerCard();

        if (game.getPlayerTotal() >= 21) {
            if (game.getPlayerTotal() > 21) {
                game.revealDealer();
                game.setState(new GameOverState());
            } else {
                // Bij 21 eindigt de beurt en speelt de dealer
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
