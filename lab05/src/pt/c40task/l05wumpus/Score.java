package pt.c40task.l05wumpus;

public class Score {
	private int score = 0;
	private boolean possuiOuro = false;
	private Controle controle;
	
	public Score(Controle controle) {
		this.controle = controle;
	}
	
	public void pegouOuro() {
		possuiOuro = true;
	}
	
	public void perdeuBuracoOuWumpus() {
		score -= 1000;
	}
	
	public void saiuDaCaverna() {
		if (possuiOuro) score += 1000;
	}
	
	public void seMoveu() {
		score -= 15;
	}
	
	public void usouFlecha() {
		score -= 100;
	}
	
	public void matouWumpus() {
		score -= 500;
	}
	
	public int getScore() {
		return score;
	}

}
