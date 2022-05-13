package pt.c40task.l05wumpus;

public class Buraco extends Componente {
	public Buraco(int x, int y, char funcao){
		super(x, y, funcao);
	}
	
	public void conectaCaverna(Caverna caverna) {
		super.conectaCaverna(caverna);
		inserirBrisa(super.caverna);
	}
	
	private void inserirBrisa(Caverna caverna) {
		// TO DO
	}
	
}
