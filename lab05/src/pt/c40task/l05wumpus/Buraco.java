package pt.c40task.l05wumpus;

public class Buraco extends Componente {
	public Buraco(int x, int y){
		super(x, y, 'B');
	}
	
	public void conectaCaverna(Caverna caverna) {
		super.conectaCaverna(caverna);
		caverna.espalharBrisa(super.getY(), super.getX());
	}
	
}
