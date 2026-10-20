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
        // De speler mag niet meer trekken tijdens de beurt van de dealer.
    }

    @Override
    public void stand(BlackjackGame game) {
        // De speler kan niet nogmaals passen tijdens de beurt van de dealer.
    }

    public void playDealerTurn(BlackjackGame game) {
        // De dealer trekt kaarten totdat hij minstens 17 punten heeft.
        while (game.getDealerTotal() < 17) {
            game.drawDealerCard();
        }

        // De dealerkaarten worden zichtbaar.
        game.revealDealer();

        // De ronde is afgelopen.
        game.setState(new GameOverState());
    }
}
