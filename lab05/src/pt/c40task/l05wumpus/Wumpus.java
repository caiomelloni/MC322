package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
	public Wumpus(int x, int y) {
		super(x, y, 'W');
	    
	}
	
	static char getFuncao() {
		return 'W';
	}
	
	private void espalharFedor(Caverna caverna) {
		caverna.espalharFedor(super.getY(), super.getX());
		return;
	}
	
	public void conectaCaverna(Caverna caverna) {
		super.conectaCaverna(caverna);
		espalharFedor(caverna);
	}
}
