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
				Componente comp = new Vazio(i + 1, j + 1);
				salas[i][j] = new Sala(comp);
			}
		}
	}
	
	public void setSala(int x, int y, Componente comp) {
		salas[x - 1][y - 1] = new Sala(comp);
	}
	
}
