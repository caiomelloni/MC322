package pt.c40task.l05wumpus;

public class Caverna {
	Sala salas[][] = new Sala[4][4];
	
	public Caverna() {
		initSalas();
	}
	
	void conectaComp(Componente componente, int x, int y) {
		// conecta o componente a sua sala
	}
	
	private void initSalas() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// inicializa salas vazias
			}
		}
	}
}
