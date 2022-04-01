package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	private int tamanhoLombriga;
	private int posicaoLombriga;
	private int tamanhoAquario;
	private boolean viradaPraEsquerda = true;
	
	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoInicial) {
		this.tamanhoAquario = tamanhoAquario;
		if (tamanhoLombriga > tamanhoAquario) {
			this.tamanhoLombriga = tamanhoAquario;
		}
		else {
			this.tamanhoLombriga = tamanhoLombriga;
		}
		
		if (posicaoInicial > tamanhoAquario || posicaoInicial < 1) {
			this.posicaoLombriga = 1;
		} else {
			this.posicaoLombriga = posicaoInicial;
		}
	}
	
	void crescer() {
		if (viradaPraEsquerda) {
			int espacoDisponivel = tamanhoAquario - (posicaoLombriga + tamanhoLombriga - 1);
			
			if (espacoDisponivel > 0) tamanhoLombriga++;
			
		} else {
			int espacoDisponivel = tamanhoAquario - (tamanhoAquario - posicaoLombriga) - tamanhoLombriga;
			
			if (espacoDisponivel > 0) tamanhoLombriga++;
		}
	}
	
	void mover() {
		if (viradaPraEsquerda) {
			if(posicaoLombriga > 1) {
				posicaoLombriga--;
			} else {
				posicaoLombriga = tamanhoLombriga;
				viradaPraEsquerda = false;
			}
		} else {
			if (posicaoLombriga < tamanhoAquario) {
				posicaoLombriga++;
			} else {
				posicaoLombriga = tamanhoAquario - tamanhoLombriga + 1;
				viradaPraEsquerda = true;
			}
		}
	}
	
	void virar() {
		if (viradaPraEsquerda) {
			viradaPraEsquerda = false;
			posicaoLombriga = posicaoLombriga + tamanhoLombriga - 1;
		} else {
			viradaPraEsquerda = true;
			posicaoLombriga = posicaoLombriga - tamanhoLombriga + 1;
		}
	}
	
	String apresenta() {
		String lombriga = "";
		if(viradaPraEsquerda) {
			for (int i = 0; i < tamanhoAquario; i++) {
				if(i == (posicaoLombriga - 1)) {
					lombriga = lombriga.substring(0,i) + "O";
					continue;
				} else if((i > (posicaoLombriga - 1)) && (i <= (posicaoLombriga + tamanhoLombriga - 2))) {
					lombriga = lombriga.substring(0,i) + "@";
					continue;
				}
				lombriga = lombriga.substring(0,i) + "#";
			}
		} else {
			for (int i = 0; i<tamanhoAquario; i++) {
				if (i == (posicaoLombriga - 1)) {
					lombriga = lombriga.substring(0,i) + "O";
					continue;
				} else if((i > (posicaoLombriga-1)) || i < (posicaoLombriga - tamanhoLombriga)) {
					lombriga = lombriga.substring(0,i) + "#";
					continue;
				}
				lombriga = lombriga.substring(0,i) + "@";

			}
		}
		
		return lombriga;
	}
}
