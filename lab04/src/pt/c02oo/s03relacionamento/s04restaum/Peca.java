package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private char coluna;
	private int linha;
	private boolean comidaOuInvalida;
	private char simbolo;
	
	public Peca(int linha, char coluna) {
		this.coluna = coluna;
		this.linha = linha;
		// se esta no meio
		if (linha == 4 && coluna == 'd') {
			comidaOuInvalida = true;
			simbolo = '-';
		// se esta no tabuleiro mas fora do jogo
		} else if (posicaoEhValida(linha, coluna) == ' ') {
			comidaOuInvalida = true;
			simbolo = ' ';
		
		// se esta no jogo ou em uma posicao indisponivel
		} else {
			char simboloPosicao = posicaoEhValida(linha, coluna);
			comidaOuInvalida = (simboloPosicao != 'P');
			simbolo = simboloPosicao;
		}
	}
	
	// '#' se esta fora do tabuleiro, 'p' se esta em posicao valida dentro do tabuleiro,
	// ' ' se esta no tabuleiro em uma posicao fora do jogo 
	private char posicaoEhValida(int linha, char coluna) {
		
		if (coluna < 97 || coluna > 103 || linha <= 0 || linha > 7) {
			System.out.println("posicao fora do tabuleiro");
			return '#';
		}
		
		if ((coluna >= 'a' && coluna <= 'b') || (coluna >= 'f' && coluna <= 'g')) {
			if ((linha >= 1 && linha <= 2) || (linha >= 6 && linha <= 7)) {
				return ' ';
			}
		}
		return 'P';
	}
	
	// se é uma posicao valida para se colocar outra peça "-"
	boolean ehEspacoValido() {
		return (simbolo == '-');
	}
	
	char getSimbolo() {
		return simbolo;
	}
	
	void serComida() {
		comidaOuInvalida = true;
		if (simbolo == 'P') {
			simbolo = '-';
		}
	}
	
	void serDescomida() {
		comidaOuInvalida = false;
		if (simbolo == '-') {
			simbolo = 'P';
		}
	}
	
	void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	int getLinha() {
		return linha;
	}
	
	char getColuna() {
		return coluna;
	}
	
	
	void mover(Peca pecaTroca, Peca pecaComida) {
		if (comidaOuInvalida) return;
		if (!pecaTroca.ehEspacoValido()) return; 
		int linhaDestino = pecaTroca.getLinha();
		char colunaDestino = pecaTroca.getColuna();

		
		if (pecaTroca.getSimbolo() == '-') {
			// se estao na distancia certa entre si
			int distanciaColuna = Math.abs(colunaDestino - coluna);
			int distanciaLinha = Math.abs(linhaDestino - linha);
			
			if((distanciaColuna == 2 && distanciaLinha == 0) || (distanciaColuna == 0 && distanciaLinha == 2)) {
				pecaTroca.serDescomida();
				serComida();
				pecaComida.serComida();
			}
		}
	}
}
