/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Game.Coordonnees;

/**
 *
 * @author Alexis
 */
public class IATracker extends IAGraphe {
    
    IATracker(InterfaceGame _game) {
        super(_game);
    }
    
    @Override
    public void start() {
        while(!gameEnded()){
            Coordonnees posPacMan = game.positionPacMan();
            super.moveTo("fantome", (int) posPacMan.getX(), (int) posPacMan.getY());
            game.start();
        }
    } 
}
