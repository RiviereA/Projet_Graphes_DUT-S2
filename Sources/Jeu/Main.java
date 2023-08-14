/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Game.Game;

/**
 *
 * @author simonetma
 */
public class Main {
    
    public static void  main(String[] args){
        InterfaceGame myGame = new Game("niveau.txt");
        
        //IA myIA = new IAMianGauche(myGame);
        //IA myIA = new IARandom(myGame);
        IA myIA = new IATracker(myGame);

        myIA.start();

          
    }
    
}
