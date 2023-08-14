package Game;

import IHM.MainFrame;
import Jeu.InterfaceGame;
import static java.lang.Thread.sleep;

public class Game implements InterfaceGame {

	private Niveau niveau;
	private Fantome fantome;
	private PacMan pacman;
        private MainFrame mainframe;

        //constructeur à partir d'un fichier txt
	public Game(String nomFichier) {
            try {
                this.niveau = new Niveau(nomFichier);
		this.fantome = new Fantome(this.niveau);
                this.pacman = new PacMan(this.niveau);
                this.mainframe = new MainFrame(this);
                this.mainframe.setVisible(true);
                sleep(1500);
            }
            catch(Exception e) {
                System.out.println("Impossible de lire le fichier niveau !");
                System.out.println(e);
            }
	}

        @Override
	public void ajoutMouvementFantome(Mouvement m) {
            this.fantome.ajoutMouvement(m);
	}

        @Override
	public void ajoutMouvementPacMan(Mouvement m) {
            this.pacman.ajoutMouvement(m);
	}
        
        @Override
	public int coutMouvementCase(int i, int j) {
		return this.niveau.getCase(i, j).CoutMouvement();
	}

        @Override
	public void start() {
            try {
                while(actionsTour()) {
                    sleep(300);
                }
                if(this.isLost()) {
                    System.out.println("PacMan est mort :(");
                }
                else if(this.isWin()) {
                    System.out.println("PacMan a gagné !");
                }
            }
            catch(Exception e) {
                System.err.println("Arret du timer !");
            }
	}

        //actions effectuées à chaque tour
	public boolean actionsTour() {
            if(this.isLost() || this.isWin()) {
                return false;
            }
            else {
                boolean ActionPacMan = this.pacman.agir();
                boolean ActionFantome = this.fantome.agir();
		return (ActionPacMan || ActionFantome);
            }
	}

        //a-t-on gagné ?
	public boolean isWin() {
		return this.pacman.getStatu().equals("Vivant") && !this.niveau.hasPacGomme();
                
	}
        
        //a-t-on perdu ?
	public boolean isLost() {
		return this.pacman.getStatu().equals("Mort");
	}

        //getteur niveau
	public Niveau getNiveau() {
		return this.niveau;
	}
        
        //getteur largeur
        public int getLargeur() {
            return this.niveau.getLargeur();
        }
        
        //getteur hauteur
        public int getHauteur() {
            return this.niveau.getHauteur();
        }

    @Override
    public String typeCase(int i, int j) {
        return this.niveau.getCase(i, j).type();
    }
    
        @Override
    public Coordonnees positionPacMan() {
        return this.pacman.getCase().getPosition();
    }
       
 
    
        @Override
    public Coordonnees positionFantome() {
        return this.fantome.getCase().getPosition();
    }

    public String statusPacMan() {
        return this.pacman.getStatu();
    }
    

}