package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private int score = 0;
	private boolean possuiFlecha = true;
	private boolean flechaEquipada = false;
	private String nome;
	
	public Heroi(int x, int y, String nome) {
		super(x, y, 'H');
		this.nome = nome;
	}
	
	public int getScore() {
		return score;
	}
	
	public void incScore(int add) {
		score += add;
	}
	
	public void equiparFlecha() {
		if (possuiFlecha) {
			flechaEquipada = true;
			possuiFlecha = false;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void mover(int x, int y) {
		super.mover(x, y);
		atirar();
	}
	
	private void atirar() {
		if(flechaEquipada) {
			flechaEquipada = false;
		}
	}

}
