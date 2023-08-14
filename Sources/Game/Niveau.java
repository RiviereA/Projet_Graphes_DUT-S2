package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Niveau {

	private Game game;
	private HashMap<Coordonnees,Case> cases;
	private Couloir departPacMan;
	private Couloir departFantome;
        int largeur;
        int hauteur;

        //Chargement du niveau à partir du fichier texte
       public Niveau(String nomFichier) throws FileNotFoundException, IOException {
           this.departFantome = null;
           this.departPacMan = null;
           this.cases = new HashMap<>();
           
           String ligne;
           //ouverture du fichier en lecture
           BufferedReader Fichier = new BufferedReader(new FileReader(nomFichier));

           int nbLigne = 0;
           largeur = 0;
           
           //lecture ligne à ligne
           while((ligne = Fichier.readLine()) != null) {
               nbLigne++;
               //la largeur du niveau est le max des largeurs des lignes
               if(ligne.length()> largeur) {
                   largeur = ligne.length();
               }
               for(int nbColonne = 0;nbColonne < ligne.length();nbColonne++) {
                   Coordonnees position = Coordonnees.Create(nbLigne,nbColonne+1);
                   if(ligne.substring(nbColonne,nbColonne+1).equals(" ") || ligne.substring(nbColonne,nbColonne+1).equals("P") || ligne.substring(nbColonne,nbColonne+1).equals("F")) {
                       //création d'un couloir sans pacGomme
                       Couloir laCase = new Couloir(this,position,false);
                       this.cases.put(position, laCase);
                       //gestion des cases de départ
                       if(ligne.substring(nbColonne,nbColonne+1).equals("P")) { this.departPacMan = laCase; }
                       if(ligne.substring(nbColonne,nbColonne+1).equals("F")) { this.departFantome = laCase; }
                       
                   }
                   else if(ligne.substring(nbColonne,nbColonne+1).equals(".")) {
                       //création d'un couloir avec pacGomme
                       this.cases.put(position, new Couloir(this,position,true));
                   }
                   else if(ligne.substring(nbColonne,nbColonne+1).equals("b")) {
                       //création d'un brouillard sans pacGomme
                       this.cases.put(position, new Brouillard(this,position,false));
                   }
                   else if(ligne.substring(nbColonne,nbColonne+1).equals("B")) {
                       //création d'un brouillard avec pacGomme
                       this.cases.put(position, new Brouillard(this,position,true));
                   }
                   else {
                        this.cases.put(position, new Mur(this,position));
                   }
               }
           }
           //la hauteur du niveau est le nombre de ligne du fichier
           hauteur = nbLigne;
       } 
               
       //renvoie s'il y a des pacGomme sur le niveau
       public boolean hasPacGomme() {
           boolean res = false;
           for(Case maCase : this.cases.values()) {
               if(maCase.getGomme() != null) {
                   res = true;
               }
           }
           return res;
       }
       
       //Getteur --------------------------------------------------------------------
	public Couloir getDepartPacMan() {
            if(this.departPacMan == null) {
                System.err.println("Le niveau ne possède pas de case de départ pour PacMan !");
            }
		return this.departPacMan;
	}

	public Couloir getDepartFantome() {
            if(this.departFantome == null) {
                System.err.println("Le niveau ne possède pas de case de départ pour le Fantôme !");
            }
		return this.departFantome;
	}
        
        public Case getCase(Coordonnees c) {
            return cases.get(c);
        }
        public Case getCase(int i, int j) {
            return cases.get(Coordonnees.Create(i,j));
        }
        
        public int getLargeur() {
            return this.largeur;
        }
        
        public int getHauteur() {
            return this.hauteur;
        }

}