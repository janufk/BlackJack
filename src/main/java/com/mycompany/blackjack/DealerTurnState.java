package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 20253182
 */
public class DealerTurnState implements GameState {

    @Override
    public void hit(BlackjackGame game) {
       
    }

    @Override
    public void stand(BlackjackGame game) {
  
    }

    public void playDealerTurn(BlackjackGame game) {
        
        while (game.getDealerTotal() < 17) {
            game.drawDealerCard();
        }


        game.revealDealer();


        game.setState(new GameOverState());
    }
}
