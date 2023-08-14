package Game;

import IHM.*;

public abstract class Case  {

	private Niveau niveau;
	private Entite entite;
	private Coordonnees position;
        private PanelImage image;

        //constructeur
        public Case(Niveau _niveau, Coordonnees c) {
            this.niveau = _niveau;
            this.position = c;
            this.entite = null;
        }
        
        //getteur position
        public Coordonnees getPosition() {
            return this.position;
        }
        
        //setter image
        public void setImage(PanelImage _image) {
            this.image = _image;
        }
        
        //reload image
        public void reload() {
            if(this.image != null) {
                this.image.reload();
            }
        }
      
        //cout du mouvement vers cette case
	public abstract int CoutMouvement();

        //renvoie la pacGomme présente dans cette case s'il y en a une
	public abstract PacGomme getGomme();
        
        //enleve la pacGomme (ne fait rien de base, surchargée pour les couloirs);
        public void removePacGomme() {
        
        }
        
        //type de la case
        public abstract String type();
        
        //rajoute une entite sur la case
        public void addEntite(Entite _entite) {
            this.entite = _entite;
        }
        
        public Entite getEntite() {
            return this.entite;
        }
        
        //renvoie la case situé dans le direction m par rapport à la case active
        public Case getVoisin(Mouvement m) {
		return this.niveau.getCase(this.position.translate(m));
	}
        
}