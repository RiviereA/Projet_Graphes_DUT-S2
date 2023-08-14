/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

import Game.Mouvement;
import java.util.ArrayList;

/**
 *
 * @author am728605
 */
public class IARandom extends IA {

    IARandom(InterfaceGame _game) {
        super(_game);
    }
    
    @Override
    public void start() {
        
        ArrayList<Mouvement> mouvs;
        Mouvement lastMouvement = null;
        while(!gameEnded()){
        
            mouvs = getAvailableMoves();
            if(lastMouvement != null && mouvs.size() > 1) {
                mouvs.remove(lastMouvement);
            }
            int randIndex =  (int)(Math.random() * ((mouvs.size() - 1) + 1));
            lastMouvement = mouvs.get(randIndex).inverser();
            game.ajoutMouvementPacMan(mouvs.get(randIndex));
       
            game.start();
        }    
    }
}
