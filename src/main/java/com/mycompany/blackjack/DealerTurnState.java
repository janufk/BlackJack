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

public class DealerTurnState implements GameState {

    @Override
    public void hit(BlackjackGame game) {
        //The player is not able to hit anymore
    }

    @Override
    public void stand(BlackjackGame game) {
        while (game.getDealerTotal() < 17) {
            game.drawDealerCard();
        }

        game.setState(new GameOverState());
    }
}
