package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna = null;
	
	public void initCaverna() {
		caverna = new Caverna();
	}
	
	public void inserirComponente(String comando) {
		int x = comando.charAt(0) - 48;
		int y = comando.charAt(2) - 48;
		char funcao = comando.charAt(4);
		
		
	}
}
