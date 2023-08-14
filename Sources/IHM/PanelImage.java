package IHM;

import Game.Case;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImage extends JPanel{
    private Image image;
    private Case laCase;
    
    public PanelImage (String _type) {
        try {
            this.setPreferredSize(new Dimension(20,20));
            image = ImageIO.read(new File("mur.jpg"));
        }
        catch(Exception e) {
            System.err.println("Impossible de lire les fichiers images");
        }
    }
    
    public PanelImage (Case _laCase) {
            this.laCase = _laCase;
            _laCase.setImage(this);
            this.chargementImage();
    }
    
    public final void chargementImage() {
        if(laCase.type().equals("Mur")) {
                image = BibliothequeImage.getImage("mur");
            }
            else {
                if(laCase.getEntite() != null) {
                    if(laCase.getEntite().isPacMan()) {
                        image = BibliothequeImage.getImage("pacman");
                    }
                    else {
                        image = BibliothequeImage.getImage("fantome");
                    }
                }
                else {
                    if(laCase.type().equals("Couloir")) {
                        if(laCase.getGomme() != null) {
                            image = BibliothequeImage.getImage("pacgomme");
                        }
                        else {
                            image = BibliothequeImage.getImage("couloir");
                        }
                    }
                    else {
                        if(laCase.getGomme() != null) {
                            image = BibliothequeImage.getImage("pacgommeB");
                        }
                        else {
                            image = BibliothequeImage.getImage("brouillard");
                        }
                    }
                }
            }
    }
    
    public void reload() {
        this.chargementImage();
        this.revalidate();
        this.repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        image = image.getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(image,0,0,null);
    }
}