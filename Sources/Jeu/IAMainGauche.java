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
public class IAMainGauche extends IA {
    
    
    private Mouvement leftMove;
    
    public IAMainGauche(InterfaceGame _game) {
        super(_game);
        leftMove = Mouvement.Left;
    }
    
    @Override
    public void start() {
        
        ArrayList<Mouvement> moves = getAvailableMoves("fantome");
        if(moves.contains(Mouvement.Left)){
            while(true){
                moves = getAvailableMoves("fantome");
                if(!moves.contains(Mouvement.Up)) {
                    leftMove = Mouvement.Up;
                    break;
                }
                game.ajoutMouvementFantome(Mouvement.Up);  
                game.start();
            }            
        }
        
   

        while(!gameEnded()){
            moves = getAvailableMoves("fantome");
                   
            if(moves.contains(getAbsoluteMove(Mouvement.Left))){
                game.ajoutMouvementFantome(getAbsoluteMove(Mouvement.Left));
                leftMove = getAbsoluteMove(Mouvement.Down);
            } else {
                if(moves.contains(getAbsoluteMove(Mouvement.Up))){
                    game.ajoutMouvementFantome(getAbsoluteMove(Mouvement.Up)); 
                } else {
                    if(moves.contains(getAbsoluteMove(Mouvement.Right))){
                        game.ajoutMouvementFantome(getAbsoluteMove(Mouvement.Right));  
                    }
                    leftMove = getAbsoluteMove(Mouvement.Up);                        
                   
                    
                }               
            }
            
            game.start();
        }
        

    }
    
        

    private Mouvement getAbsoluteMove(Mouvement move) {
        
        if(leftMove.equals(Mouvement.Right)) return move.inverser(); 
        if(leftMove.equals(Mouvement.Up)) return move.rotation();   
        if(leftMove.equals(Mouvement.Down)) return move.rotation().inverser();
        
        return move;     
    }
    
   
}
