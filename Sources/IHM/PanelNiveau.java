package IHM;

import Game.Niveau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelNiveau extends JPanel {
    
        private Niveau niveau;
        private ArrayList<PanelImage> pImages;
    
    public PanelNiveau(Niveau _niveau) {
        super();
        this.niveau = _niveau;
        this.setPreferredSize(new Dimension(20,20));
        this.setLayout(new GridLayout(niveau.getHauteur(),niveau.getLargeur()));
        pImages = new ArrayList<>();
        this.chargementElements();
    }
    
    public final void chargementElements() {
        this.removeAll();
        for(int i=1;i<=niveau.getHauteur();i++) {
            for(int j=1;j<=niveau.getLargeur();j++) {
                PanelImage monPanel;
                if(niveau.getCase(i, j) != null) {
                    monPanel = new PanelImage(niveau.getCase(i,j));
                }
                else {
                    monPanel = new PanelImage("mur");
                }
                this.add(monPanel);
                this.pImages.add(monPanel);
            }
        }
        this.validate();
    }
    
}