package Game;

import java.util.*;

public class IA {

	private ArrayList<Mouvement> mouvements;

        //constructeur
        public IA() {
            this.mouvements = new ArrayList<>();
        }
        
        //enleve le dernier mouvement s'il y en a un
	public void nextMove() {
            if(this.mouvements.size() > 0) {
		this.mouvements.remove(0);
            }
	}
        
        //renvoie le prochain mouvement à effectuer
        public Mouvement Move() {
            if(this.mouvements.size() > 0) {
                return this.mouvements.get(0);
            }
            return null;
        }
        
        //ajouter un mouvement
        public void addMouvement(Mouvement m) {
            this.mouvements.add(m);
        }
        
        //vide l'ia
        public void clear() {
            this.mouvements.clear();
        }
        
        public void addWait() {
            this.mouvements.add(0,Mouvement.Pause);
        }

}