/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Agilian
 */
public class BibliothequeImage {
    static private Image pacman;
    static private Image fantome;
    static private Image mur;
    static private Image couloir;
    static private Image pacgomme;
    static private Image pacgommeB;
    static private Image brouillard;
    
    static public void chargementImage() {
        try {
            pacman = ImageIO.read(new File("pacman.jpg"));
            fantome = ImageIO.read(new File("fantome.jpg"));
            mur = ImageIO.read(new File("mur.jpg"));
            couloir = ImageIO.read(new File("couloir.jpg"));
            pacgomme = ImageIO.read(new File("pacgomme.jpg"));
            pacgommeB = ImageIO.read(new File("pacgommeB.jpg"));
            brouillard = ImageIO.read(new File("brouillard.jpg"));
        }
        catch(Exception e) {
            System.err.println("Impossible de lire les fichiers images");
        }
    }
    
    static public Image getImage(String name) {
        if(name.equals("pacman")) {
            return pacman;
        }
        else  if(name.equals("fantome")) {
            return fantome;
        }
        else  if(name.equals("mur")) {
            return mur;
        }
        else  if(name.equals("couloir")) {
            return couloir;
        }
        else  if(name.equals("pacgomme")) {
            return pacgomme;
        }
        else  if(name.equals("pacgommeB")) {
            return pacgommeB;
        }
        else  if(name.equals("brouillard")) {
            return brouillard;
        }
        return null;
    }
}
