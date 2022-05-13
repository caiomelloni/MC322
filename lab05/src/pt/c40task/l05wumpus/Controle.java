package pt.c40task.l05wumpus;

public class Controle {
	private int score;
	private Componente componentes[][] = new Componente[4][4];
	private boolean gameOver = false;
	
	public Controle() {
		
	}
	
	private void incScore(int add) {
		score += add;
	}
	
	public void moverHeroi(int x, int y) {
		
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void restartGame() {
		
	}
	
	public void resetGame() {
		restartGame();
		score = 0;
	}
	
	private Componente getHeroi() {
		return componentes[0][0];
	}
}
