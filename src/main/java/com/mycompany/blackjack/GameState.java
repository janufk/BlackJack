package com.mycompany.blackjack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20253182
 */
public interface GameState {
    void hit(BlackjackGame game);
    void stand(BlackjackGame game);
}
