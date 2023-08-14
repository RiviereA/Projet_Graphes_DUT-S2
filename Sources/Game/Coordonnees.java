package Game;

import java.util.ArrayList;

public class Coordonnees {

	private double x;
	private double y;

        private static ArrayList<Coordonnees> instances = new ArrayList<>();
        
        //constructeur du multiton
        public static Coordonnees Create(double _x, double _y) {
            for(Coordonnees c : instances) {
                if(c.equals(_x, _y)) {
                    return c;
                }
            }
            Coordonnees c = new Coordonnees(_x,_y);
            instances.add(c);
            return c;
        }
        
        //constructeur du multiton en int
        public static Coordonnees Create(int x,int y) {
            return Create((double) x, (double) y);
        }
        
        //test d'égalité pour le multiton
        public boolean equals(double i,double j) {
            return (this.x == i && this.y==j);
        }
        
        //Constructeurs ----------------------------------------------------------
        private Coordonnees(double _x, double _y) {
            this.x = _x;
            this.y = _y;
        }
        
        private Coordonnees(int _x,int _y) {
            this.x = _x;
            this.y = _y;
        }
        
        //Getteur ----------------------------------------------------------------
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
       
        //Autres fonction ---------------------------------------------------------
        public Coordonnees translate(Mouvement m) {
            switch(m) {
                case Up :
                    return Coordonnees.Create(this.getX() - 1, this.getY());
                case Down : 
                    return Coordonnees.Create(this.getX() + 1, this.getY());
                case Left :
                    return Coordonnees.Create(this.getX(), this.getY() - 1);
                case Right :
                    return Coordonnees.Create(this.getX(), this.getY() + 1);
                case Pause :
                    return this;
            }
            return null;
        }

}