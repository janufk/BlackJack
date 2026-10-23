package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gwynerwitkamp
 * @id 2375125
 * @author janufkrishnan
 * @id 2224429
 */
public class PlayerTurnState implements GameState {

    @Override
    public void hit(BlackjackGame game) {
        // Player draws cards.
        game.drawPlayerCard();

        // Player total is more than 21, game ends.
        if (game.getPlayerTotal() > 21) {
            game.revealDealer();
            game.setState(new GameOverState());
        }
    }

    @Override
    public void stand(BlackjackGame game) {
        game.setState(new DealerTurnState());
    }
}
