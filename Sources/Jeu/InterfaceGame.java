package Jeu;

import Game.*;

public interface InterfaceGame {

        //ajoute un mouvement pour le fantome
	abstract void ajoutMouvementFantome(Mouvement m);
        //ajoute un mouvement pour pacman
	abstract void ajoutMouvementPacMan(Mouvement m);
        //démarre le jeu
	abstract void start();
        //renvoie le cout en mouvement d'une case
	abstract int coutMouvementCase(int i, int j);
        //renvoie la largeur du niveau
        abstract int getLargeur();
        //renvoie la hauteur du niveau
        abstract int getHauteur();
        //renvoie le type de la case
	String typeCase(int i, int j);
        //renvoie la position de pacman
        Coordonnees positionPacMan();
        //renvoie la position du fantome
        Coordonnees positionFantome();
        
        String statusPacMan();
	boolean isWin();
	boolean isLost();
       

}