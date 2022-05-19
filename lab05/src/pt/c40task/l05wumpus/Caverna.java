package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][] = new Sala[4][4];
	
	public Caverna() {
		initSalas();
	}
	
	public void conectaComp(Componente componente, int x, int y) {
		salas[y][x] = new Sala(componente);
	}
	
	private void initSalas() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Componente comp = new Vazio(i + 1, j + 1);
				salas[i][j] = new Sala(comp);
			}
		}
	}
	
	public void moverHeroi(Heroi heroi, int oldY, int oldX, Score score) {
		int newX = heroi.getX();
		int newY = heroi.getY();
		
		salas[oldY][oldX].retirarHeroi();
		salas[newY][newX].inserirHeroi(heroi, score);
	}
	
	public void imprimeCaverna() {
		for (int linha = 0; linha < 4; linha++) {
			for (int coluna = 0; coluna < 4; coluna++) {
				System.out.print(salas[linha][coluna].getComponenteFuncao());
			}
			System.out.println();
		}
	}
	
	// true se pegou, false caso contrário
	public boolean pegaOuro(int y, int x) {
		return salas[y][x].saquearSala();
	}
	
	public void espalharFedor(int y, int x) {
		for (int coluna = x - 1; coluna <= x + 1; coluna++) {
			if(!Controle.coordenadasValidas(y, coluna)) continue;
			salas[y][coluna].colocarFedor();
		}
		
		for (int linha = y - 1; linha <= y + 1; linha++) {
			if(!Controle.coordenadasValidas(linha, x)) continue;
			salas[linha][x].colocarFedor();
		}
	}
	
	public void espalharBrisa(int y, int x) {
		for (int coluna = x - 1; coluna <= x + 1; coluna++) {
			if(!Controle.coordenadasValidas(y, coluna)) continue;
			salas[y][coluna].colocarBrisa();
		}
		
		for (int linha = y - 1; linha <= y + 1; linha++) {
			if(!Controle.coordenadasValidas(linha, x)) continue;
			salas[linha][x].colocarBrisa();
		}
	}
	
	// presume que a flecha está equipada
	public void matarWumpus(int y, int x, Heroi heroi) {
		salas[y][x].matarWumpus(x, y);
	}

	public void resetarJogo(Heroi heroi) {
		salas[heroi.getY()][heroi.getX()].retirarHeroi();
		heroi.setX(0);
		heroi.setY(0);
		for (int i = 0; i<4;i++) {
			for (int j = 0; j<4; j++) {
				salas[i][j].esconderComponente();
			}
		}
		salas[0][0].inserirHeroi(heroi);
	}
	
}
