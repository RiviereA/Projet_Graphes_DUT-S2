/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

import Game.Game;
import Game.Mouvement;
import java.util.ArrayList;

/**
 *
 * @author am728605
 */
public abstract class IA {
    protected InterfaceGame game;
    
    public IA() {
        game = new Game("niveau.txt");
    }
    
    public IA(InterfaceGame _game) {
        game = _game;
    }
    
    public abstract void start();
    
    protected boolean isWall(int x, int y) {
        if(x < 1 || y < 1 || y > game.getHauteur() || x > game.getLargeur()){
            return true;
        }
        return game.typeCase(x, y).equals("Mur");
    }
    
    protected ArrayList getAvailableMoves(String character) {
        int x;
        int y;
        
        if(character.equals("fantome")){
            x = (int) game.positionFantome().getX();
            y = (int) game.positionFantome().getY();
        }else {
            x = (int) game.positionPacMan().getX();
            y = (int) game.positionPacMan().getY();       
        }

        ArrayList<Mouvement> res = new ArrayList();
        if(!isWall(x+1, y)) res.add(Mouvement.Down);
        if(!isWall(x-1, y)) res.add(Mouvement.Up);
        if(!isWall(x, y+1)) res.add(Mouvement.Right);
        if(!isWall(x, y-1)) res.add(Mouvement.Left);

        return res;
    }
    protected ArrayList getAvailableMoves() {
        return getAvailableMoves("pacman");
    }
    
    protected boolean gameEnded() {
        return game.isWin() || game.isLost();
    }
}
