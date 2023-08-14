/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import Game.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import sun.tools.jar.Main;

/**
 *
 * @author Agilian
 */
public class MainFrame extends javax.swing.JFrame {

    private PanelNiveau pNiveau;
    private Game game;
    
    public MainFrame(Game _myGame) {
        this.game = _myGame;
        BibliothequeImage.chargementImage();
        initComponents();
        chargementElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void chargementElements() {
        //formatage de la fenetre
        this.setTitle("PacMan");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //panel du niveau        
        pNiveau = new PanelNiveau(game.getNiveau());
        this.setMinimumSize(new Dimension(600,600));
        pNiveau.chargementElements();
        this.add(pNiveau, BorderLayout.CENTER);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
