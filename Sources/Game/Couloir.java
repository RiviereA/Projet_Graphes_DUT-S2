package Game;

public class Couloir extends Case {

	private PacGomme pacgomme;

        //constructeurs
        public Couloir(Niveau _niveau, Coordonnees c) {
            super(_niveau, c);
            this.pacgomme = null;
        }
        
        public Couloir(Niveau _niveau, Coordonnees c, boolean hasPacGome) {
            this(_niveau,c);
            if(hasPacGome) {
                this.pacgomme = new PacGomme(this);
            }
        }

        @Override
	public int CoutMouvement() {
		return 1;
	}

        @Override
	public PacGomme getGomme() {
		return this.pacgomme;
	}
        
        @Override
        public void removePacGomme() {
            this.pacgomme = null;
        }

    
    @Override
    public String type() {
        return "Couloir";
    }

}