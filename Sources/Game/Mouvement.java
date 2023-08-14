package Game;

public enum Mouvement {
	Up, Down, Left, Right, Pause;

	public Mouvement inverser() {
            switch(this) {
                case Up : return Down;
                case Down : return Up;
                case Left : return Right;
                case Right : return Left;
                case Pause : return Pause;
            }
            return null;
	}
        
        public Mouvement rotation() {
            switch(this) {
                case Up : return Right;
                case Down : return Left;
                case Left : return Up;
                case Right : return Down;
                case Pause : return Pause;
            }
            return null;
	}

}