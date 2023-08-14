package Game;

public class Brouillard extends Couloir {

        public Brouillard(Niveau _niveau, Coordonnees c) {
            super(_niveau,c);
        }
        
        public Brouillard(Niveau _niveau, Coordonnees c,boolean hasGomme) {
            super(_niveau, c,hasGomme);
        }

        @Override
	public int CoutMouvement() {
		return 2;
	}
        
        public String type() {
            return "Brouillard";
        }

}