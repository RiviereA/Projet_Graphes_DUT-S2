package Game;

public class Fantome extends Entite {
        
        public Fantome(Niveau niveau) {
            super();
            this.setCase(niveau.getDepartFantome());
            this.setStatu("Vivant");
        }
    
        @Override
	public boolean agir() {
            if(!this.getStatu().equals("mort")) {
                return this.bouger();   
            }
            return false;
	}

    @Override
    public boolean isPacMan() {
        return false;
    }

    @Override
    public boolean gestionRencontre(Case destination) {
        if(destination.getEntite().isPacMan()) {
            destination.getEntite().setStatu("Mort");
            destination.getEntite().setCase(null);
            this.setCase(destination);
            this.nextMove();
            return true;
        }
        else {
            if(destination.getEntite() == this) {
                this.setCase(destination);
                this.nextMove();
                return true;
            }
            System.err.println("Deux fantomes se sont percutés !");
            return false;
        }
    }


}