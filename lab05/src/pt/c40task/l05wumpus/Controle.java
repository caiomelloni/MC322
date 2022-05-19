package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Controle {
	private Score score;
	private Heroi heroi;
	
	public Controle() {
		score = new Score(this);
	}
	
	static boolean coordenadasValidas(int y, int x) {
		if (x < 0 || x > 3 || y < 0 || y > 3) {
			// fora do tabuleiro
			return false;
		}
		return true;
	}
	
	// x = 0 and y = 0 are the initial positions
	public void moverHeroi(int y, int x) {
		
		int oldX = heroi.getX();
		int oldY = heroi.getY();
		
		int deltaX = Math.abs(x - oldX);
		int deltaY = Math.abs(y - oldY);
		
		if (!coordenadasValidas(y, x)) return;
		
		if (deltaX != 0 && deltaY != 0) {
			// Error message
			System.out.println("Movimento proibido: diagonal");
			return;
		}
		if (deltaX > 1 || deltaY > 1) {
			// Error message
			System.out.println("Movimento proibido: deslocamento muito grande");
			return;	
		}
		
		heroi.mover(y, x);
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
		heroi.conectaScore(score);
	}
	
	public void ativaModoInterativo() {
		
		 /*	
		  	w -> Herói movimenta para a sala acima;
			s ->  Herói movimenta para a sala abaixo;
			d ->  Herói movimenta para a sala a direita;
			a ->  Herói movimenta para a sala a esquerda;
			k -> Herói equipa a flecha;
			c -> Herói captura o ouro;
			q -> O usuário sai do jogo.
		 */
		
		Scanner keyboard = new Scanner(System.in);
		String command = "inicio";
		
		while (command != "q") {

			fazerMovimento(command);
			command = keyboard.nextLine();
			
		}
		
		keyboard.close();
	}
	
	private void fazerMovimento(String mov) {
		int x = heroi.getX();
		int y = heroi.getY();
		
		switch(mov) {
		case "w":
			moverHeroi(y - 1, x);
			break;
		case "s":
			moverHeroi(y + 1, x);
			break;
		case "d":
			moverHeroi(y, x + 1);
			break;
		case "a":
			moverHeroi(y, x - 1);
			break;
		case "k":
			heroi.equiparFlecha();
			break;
		case "c":
			heroi.pegaOuro();
			break;
		case "q":
			heroi.sairJogo();
			break;
		}
	}
}
