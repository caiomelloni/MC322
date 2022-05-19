package pt.c40task.l05wumpus;

public class Score {
	private int score = 0;
	private boolean possuiOuro = false;
	private Controle controle;
	
	public Score(Controle controle) {
		this.controle = controle;
	}
	
	public boolean possuiOuro() {
		return possuiOuro;
	}
	
	public void pegouOuro() {
		possuiOuro = true;
	}
	
	public void perdeuBuracoOuWumpus() {
		possuiOuro = false;
		score -= 1000;
		System.out.println("Player: String" + "\nScore: " + score +"\nVoce perdeu =(...");
	}
	
	public void saiuDaCaverna() {
		if (!possuiOuro) return;
		score += 1000;
		System.out.println("Player: String" + "\nScore: " + score +"\nVoce ganhou =D !!!");
	}
	
	public void saiuDoJogo() {
		System.out.println("Player: String" + "\nScore: " + score +"\nVolte sempre !");
		score = 0;
	}
	
	public void seMoveu() {
		score -= 15;
	}
	
	public void usouFlecha() {
		score -= 100;
	}
	
	public void matouWumpus() {
		score += 500;
	}
	
	public int getScore() {
		return score;
	}

	public void placarAtual() {
		System.out.println("Player: " + "Sting");
		System.out.println("Score: " + score);
		
	}

}
