package Game;

public class Mur extends Case {

        public Mur(Niveau _niveau, Coordonnees c) {
            super(_niveau, c);
        }

        @Override
	public int CoutMouvement() {
		return -1;
	}

        @Override
	public PacGomme getGomme() {
		return null;
	}
        
    @Override
    public String type() {
        return "Mur";
    }

}