package Game;

import IHM.*;

public abstract class Entite {

	private Case saCase;
	private IA ia;
        private String statu;

        //constructeur ------------------------------------------------------------
        public Entite() {
            this.saCase = null;
            this.ia = new IA();
            this.statu = "hors jeu";
        }
        
        //GESTION DES MOUVEMENTS---------------------------------------------------
        //ajout Mouvement
        public void ajoutMouvement(Mouvement m) {
            this.ia.addMouvement(m);
        }
        
        //passe au mouvement suivant
        protected void nextMove() {
            ia.nextMove();
        }
        
        //clear l'IA
        protected void clearMove() {
            ia.clear();
        }
        
        //fait bouger l'entite en fonction de son IA ------------------------------
	protected boolean bouger() {
            if(ia.Move() != null) {
                Case destination = this.saCase.getVoisin(ia.Move());
                //si l'entite peut se deplacer sur la case
                if(this.peutSeDeplacer(destination.type())) {
                    if(destination.getEntite() != null) {
                        return this.gestionRencontre(destination);
                    }
                    this.nextMove();
                    this.setCase(destination);
                    return true;   
                }
                else {
                    this.deplacementImpossible();
                    return false;
                }
            }
            return false;
	}
        
        //gestion des rencontre entre deux entités sur la case destination
        public abstract boolean gestionRencontre(Case destination);
        
        //affiche un message d'erreur pour cause de déplacement impossible et vide l'ia
        public void deplacementImpossible() {
            if(this.isPacMan()) {
                System.err.println("Déplacement impossible pour PacMan !");
            }
            else {
                System.err.println("Déplacement impossible pour le fantôme !");
            }
            ia.clear();
        }
        
        public boolean peutSeDeplacer(String typeCase) {
            if(typeCase.equals("Mur")) {
                return false;
            }
            else {
                return true;
            }
        }

        //fonction appellé quand c'est au tour de l'entité ------------------------
	public abstract boolean agir();

        
        //GESTION DE LA POSITION --------------------------------------------------
        public Case getCase() {
            return this.saCase;
        }
        
        
        
        //Gestion du statu ---------------------------------------------------------
        public String getStatu() {
            return this.statu;
        }
        
        public void setStatu(String _statu) {
            this.statu = _statu;
        }
        
        //(dé)place l'entite dans la case donnée
        public void setCase(Case _case) {
            //enlève l'entite de la case précédente (si existe)
            Case oldcase = this.saCase;
            if(this.saCase != null) {
                this.saCase.addEntite(null);
            }
            //gestion du brouillard pour le fantome
            if(_case != null) {
                if(_case.CoutMouvement() > 1 && !this.isPacMan() && this.saCase != _case) {
                    this.ia.addWait();
                }
            }
            
            //place l'entite dans la nouvelle case
            this.saCase = _case;
            if(this.saCase != null) {
                this.saCase.addEntite(this);
            }
            
            //reload des images
            if(oldcase != null) {
                oldcase.reload();
            }
            if(this.saCase !=null) {
                this.saCase.reload();
            }
        }
                
        public abstract boolean isPacMan();

}