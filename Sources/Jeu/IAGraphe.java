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
 * @author Alexis
 */
public abstract class IAGraphe extends IA {    
    private ArrayList<NivSommet> nivGraphe;
    
    // attributs liés au graphe
    
    IAGraphe(InterfaceGame _game) {
        super(_game);
        
        // creation du graphe
    }
    
    //Initialise le graphe représentant le niveau
    public void InitGraphe(){
        nivGraphe = new ArrayList<>();
        nivGraphe.add(null);
        for (int i=1; i<=game.getHauteur();i++){
            for (int j=1; j<=game.getLargeur();j++){
                nivGraphe.add(new NivSommet((i-1)*game.getLargeur()+j, game.coutMouvementCase(i, j)));
            }
        }
    }
    
    /**
     * Méthode effectuant l'algorithme de Dijkstra afin de calculer le trajet que doit prendre le fantôme
     * @param character
     * @param x
     * @param y 
     */
    public void moveTo(String character, int x, int y) {
        InitGraphe();
        NivSommet test = new NivSommet(0,0);
        int taille = nivGraphe.size();
        int largeur = game.getLargeur();
        int hauteur = game.getHauteur();
        boolean bout = false;
        ArrayList<Boolean> mark = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        ArrayList<Integer> pi = new ArrayList<>();
        for (int i=0; i<=taille+1;i++){                 //création des tables
            mark.add(Boolean.FALSE);
            d.add(-1);
            pi.add(0);
        }
        for (int i=1; i<=taille-1;i++){                 //remplissage des tables selon Dijkstra
            int N = nivGraphe.get(i).GetNum();
            test.setNum(N);
            int C = nivGraphe.get(i).GetCout();
            test.setCout(C);
            pi.set(i, -1);
            d.set(i, 5);
            if (test.GetCout() == -1){
                mark.set(i, Boolean.TRUE);
                d.set(i, 100);
            }            
        }
        int courant= (int)((game.positionFantome().getX()-2)*10 + (game.positionFantome().getY()));
        d.set(courant, 0);  
        int a = 0;      
        while (mark.contains(Boolean.FALSE)){
            if (super.isWall((courant%hauteur)+1, ((courant-(courant%hauteur))/hauteur)) && super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur)+2)){  //On vérifie si l'on est au bord du terrain où non      
                if (mark.get(courant - largeur) == false){
                    a = courant - largeur;
                } else {
                    if (mark.get(courant -1) == false) {
                        a = courant -1;
                    } else {
                        bout = true;
                    }
                }
            } else {
                if (super.isWall((courant%hauteur)+1, ((courant-(courant%hauteur))/hauteur)) && super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur))){                    
                    if (mark.get(courant -1) == false) {
                        a = courant -1;
                    } else {                            
                        if (mark.get(courant + largeur) == false){
                            a = courant - largeur;
                        } else {
                            bout = true;
                        }                           
                    }
            
                } else {
                    if (super.isWall((courant%hauteur)-1, ((courant-(courant%hauteur))/hauteur)) && super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur)+2)){
                        if (mark.get(courant - largeur) == false){
                            a = courant - largeur;
                        } else {                
                            if (mark.get(courant +1) == false){
                                a = courant +1;
                            } else {
                                bout = true;
                            }
                        }
                    } else {
                        if (super.isWall((courant%hauteur)-1, ((courant-(courant%hauteur))/hauteur)) && super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur))){                            
                            if (mark.get(courant +1) == false){
                                a = courant +1;
                            } else {
                                if (mark.get(courant + largeur) == false){
                                    a = courant - largeur;
                                } else {
                                    bout = true;
                                } 
                            }
                        } else {
                            if (super.isWall((courant%hauteur)+1, ((courant-(courant%hauteur))/hauteur))){
                                if (mark.get(courant - largeur) == false){
                                    a = courant - largeur;
                                } else {
                                    if (mark.get(courant -1) == false) {
                                        a = courant -1;
                                    } else {
                                        if (mark.get(courant + largeur) == false){
                                            a = courant - largeur;
                                        } else {
                                            bout = true;
                                        }                    
                                    }
                                }
                            } else {
                                if (super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur)+2)){
                                    if (mark.get(courant - largeur) == false){
                                        a = courant - largeur;
                                    } else {
                                        if (mark.get(courant -1) == false) {
                                            a = courant -1;
                                        } else {
                                            if (mark.get(courant +1) == false){
                                                a = courant +1;
                                            } else {
                                                bout = true;
                                            }                    
                                        }
                                    }
                                } else {
                                    if (super.isWall((courant%hauteur)-1, ((courant-(courant%hauteur))/hauteur))){
                                        if (mark.get(courant - largeur) == false){
                                            a = courant - largeur;
                                        } else {
                                            if (mark.get(courant +1) == false){
                                                a = courant +1;
                                            } else {
                                                if (mark.get(courant + largeur) == false){
                                                    a = courant - largeur;
                                                } else {
                                                    bout = true;
                                                }                    
                                            }
                                        }
                                    } else {
                                        if (super.isWall((courant%hauteur), ((courant-(courant%hauteur))/hauteur))){                                            
                                            if (mark.get(courant -1) == false) {
                                                a = courant -1;
                                            } else {
                                                if (mark.get(courant +1) == false){
                                                    a = courant +1;
                                                } else {
                                                    if (mark.get(courant + largeur) == false){
                                                        a = courant - largeur;                        
                                                    } else {
                                                        bout = true;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (mark.get(courant - largeur) == false){
                                                a = courant - largeur;
                                            } else {
                                                if (mark.get(courant -1) == false) {
                                                    a = courant -1;
                                                } else {
                                                    if (mark.get(courant +1) == false){
                                                        a = courant +1;
                                                    } else {
                                                        if (mark.get(courant + largeur) == false){
                                                            a = courant - largeur;                        
                                                        } else {
                                                            bout = true;
                                                        }
                                                    }                    
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (bout == true){ //On vérifie si on arrive à un cul-de-sac
                courant = pi.get(courant);
            } else {
                mark.set(a, Boolean.TRUE);
                courant = a;
                for (int i = 1; i<=taille-1; i++) {
                    test.setNum(nivGraphe.get(i).GetNum());
                    test.setCout(nivGraphe.get(i).GetCout());
                    if (d.get(i) > (d.get(a) + test.GetCout())) {
                        d.set(i, (d.get(a) + test.GetCout()));
                        pi.set(i, a);
                    }
                }
            }
        }
        for (int i=1; i<=pi.size()-1; i++){ //attribution du chemin a prendre pour le fantôme (non atteint pendant la compilation)
            int position = (int)(game.positionFantome().getX() + game.positionFantome().getY()-1);
            if (pi.get(i)==position){
                if (i == (position + largeur)){
                    game.ajoutMouvementFantome(Mouvement.Up);
                } else {
                    if (i == (position + 1)){
                        game.ajoutMouvementFantome(Mouvement.Right);
                    } else {
                        if (i == (position - game.getLargeur())){
                            game.ajoutMouvementFantome(Mouvement.Down);
                        } else {
                            if (i == (position - 1)){
                                game.ajoutMouvementFantome(Mouvement.Left);
                            }
                        }
                    }
                }
            }
        }
        
    }
    
}
