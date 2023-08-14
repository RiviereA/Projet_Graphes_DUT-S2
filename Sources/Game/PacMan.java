package Game;

public class PacMan extends Entite {

         public PacMan(Niveau niveau) {
            super();
            this.setCase(niveau.getDepartPacMan());
            this.setStatu("Vivant");
        }
         
         @Override
	public boolean agir() {
            if(!this.getStatu().equals("mort")) {
                boolean res = this.bouger(); 
                if(res) {
                    if(this.getCase().getGomme() != null) {
                        //mange une pagGomme;
                        this.getCase().removePacGomme();
                    }
                }
                return res;
            }
            return false;
	}

    @Override
    public boolean isPacMan() {
        return true;
    }
    
    @Override
    public boolean gestionRencontre(Case destination) {
        if(!destination.getEntite().isPacMan()) {
            this.setCase(null);
            this.setStatu("Mort");
            this.clearMove();
            return false;
        }
        else {
            System.err.println("Deux PacMans se sont percutés !");
            return false;
        }
    }

}