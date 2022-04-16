package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca[][] tabuleiro = {new Peca[7],new Peca[7],new Peca[7],new Peca[7],new Peca[7],new Peca[7],new Peca[7],};
	
	public Tabuleiro() {
		for(int linha = 0; linha <= 6; linha++) {
			int colunaIndex = 0;
			for(char coluna = 'a'; coluna <= 'g'; coluna++) {
					tabuleiro[linha][colunaIndex] = new Peca(linha + 1, coluna);
					colunaIndex++;
			}
		}

	}
	
	public char[][] board() {
      char board[][] = {
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
    	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
    	      };
	    for (int linha = 0; linha < 7; linha++) 
	    	for (int coluna = 0; coluna < 7; coluna++) {
	    		board[linha][coluna] = tabuleiro[linha][coluna].getSimbolo();
	    	}
	    return board;
	}
	
	public void printTabuleiro() {
		for(int linha = 0; linha <= 6; linha++) {
			for (int coluna = 0; coluna <= 6; coluna++) {
				char simbolo = tabuleiro[linha][coluna].getSimbolo();
				System.out.print(simbolo);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private Peca pegarPeca(int linha, char charColuna) {
		int coluna = charColuna - 97;
		return tabuleiro[linha-1][coluna];
	}
	
	// exemplo de comando: "f4:d4" -> source:target
	void executarJogada(String comando) {
		char colunaSource = comando.charAt(0);
		char colunaTarget = comando.charAt(3);
		
		int linhaSource = comando.charAt(1) - 48;
		int linhaTarget = comando.charAt(4) - 48;
		
		mover(colunaSource, colunaTarget, linhaSource, linhaTarget);
		 
		//System.out.println("# source: " + comando.substring(0, 2) + "; target: " + comando.substring(3));
		//printTabuleiro();

	}
	
	private void mover(char colunaSource, char colunaTarget, int linhaSource, int linhaTarget) {
		Peca pSource = pegarPeca(linhaSource, colunaSource);
		Peca pTarget = pegarPeca(linhaTarget, colunaTarget);
		Peca pComida;
		
		if((colunaSource - colunaTarget) == 0) {
			if (linhaSource > linhaTarget) {
				pComida = pegarPeca(linhaSource - 1, colunaSource);
				
			} else {
				pComida = pegarPeca(linhaSource + 1, colunaSource);
			}
			
		} else {
			if (colunaSource > colunaTarget) {
				pComida = pegarPeca(linhaSource, (char) (colunaSource - 1));
			} else {
				pComida = pegarPeca(linhaSource, (char) (colunaSource + 1));
			}
		}
		
		pSource.mover(pTarget, pComida);
	}
	
}
