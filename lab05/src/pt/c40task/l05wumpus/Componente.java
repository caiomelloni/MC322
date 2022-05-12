package pt.c40task.l05wumpus;

public class Componente {
// deve possuir as coordenadas da sala, e passa para a caverna o posicionar
	private int x;
	private int y;

	private char funcao;
	
	Componente(int x, int y, char funcao) {
		this.funcao = funcao;
		this.x = x;
		this.y = y;
	}
	
	public boolean ehHeroi() {
		return funcao == 'P';
	}
	
	public boolean ehWumpus() {
		return funcao == 'W';
	}
	
	public boolean ehBuraco() {
		return funcao == 'B';
	}
	
	public boolean ehOuro() {
		return funcao == 'O';
	}
	
	public boolean ehFedor() {
		return funcao == 'f';
	}
	
	public boolean ehBrisa() {
		return funcao == 'b';
	}
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	
	public void mover(int x, int y) {
		int deslocamentoX = x - this.getX();
		int deslocamentoY = y - this.getY();
		
		if (deslocamentoX > 1 || deslocamentoX < -1) return;
		if (deslocamentoY > 1 || deslocamentoY < -1) return;
		
		this.x = x;
		this.y = y;
		
	}
}
