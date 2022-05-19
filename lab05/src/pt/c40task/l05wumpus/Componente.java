package pt.c40task.l05wumpus;

public abstract class Componente {
// deve possuir as coordenadas da sala, e passa para a caverna o posicionar
	private int x;
	private int y;
	protected Caverna caverna;

	private char funcao;
	
	Componente(int x, int y, char funcao) {
		this.funcao = funcao;
		this.x = x;
		this.y = y;
	}
	
	public char getComponenteFuncao() {
		return funcao;
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
	
	public boolean ehVazio() {
		return funcao == '#';
	}
	
	public int getX() {
		return x;
	}

	public void setX(int newX) {
		if (newX > 4 || newX < 0) return;
		x = newX;
	}

	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		if (newY > 4 || newY < 0) return;
		y = newY;
	}

	
	public void conectaCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void trocarDeLugar(Componente comp) {
		comp.conectaCaverna(caverna);
		comp.setY(this.getY());
		comp.setX(this.getX());
	}
}
