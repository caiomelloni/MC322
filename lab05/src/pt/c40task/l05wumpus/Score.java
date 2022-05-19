package pt.c40task.l05wumpus;

public class Score {
	private int score = 0;
	private boolean possuiOuro = false;
	private Controle controle;
	private String playerName;
	private char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
	
	public Score(Controle controle, String playerName) {
		this.controle = controle;
		this.playerName = playerName;
	}
	
	public char getStatus() {
		return status;
	}
	
	public boolean possuiOuro() {
		return possuiOuro;
	}
	
	public void pegouOuro() {
		possuiOuro = true;
		status = 'x';
	}
	
	public void perdeuBuracoOuWumpus() {
		possuiOuro = false;
		status = 'n';
		score -= 1000;
		System.out.println("Player: " + playerName + "\nScore: " + score +"\nVoce perdeu =(...");
	}
	
	public void saiuDaCaverna() {
		if (!possuiOuro) return;
		score += 1000;
		status = 'w';
		System.out.println("Player: " + playerName + "\nScore: " + score +"\nVoce ganhou =D !!!");
	}
	
	public void saiuDoJogo() {
		System.out.println("Player: " + playerName + "\nScore: " + score +"\nVolte sempre !");
		score = 0;
		status = 'x';
	}
	
	public void seMoveu() {
		score -= 15;
		status = 'x';
	}
	
	public void usouFlecha() {
		score -= 100;
		status = 'x';
	}
	
	public void matouWumpus() {
		score += 500;
		status = 'x';
	}
	
	public int getScore() {
		return score;
	}

	public void placarAtual() {
		System.out.println("Player: " + playerName);
		System.out.println("Score: " + score);
		
	}

	public String getPlayerName() {
		return playerName;
	}

}
