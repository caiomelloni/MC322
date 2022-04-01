package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	Toolkit tk;
	private AquarioLombriga lombriga;
	private String ordens;

	public Animacao(Toolkit tk, String instrucoesLombriga) {
		this.tk = tk;
		lombriga = criaLombriga(instrucoesLombriga);
		ordens = instrucoesLombriga.substring(6);
	}
	
	public void animar() {
		tk.gravaPasso("=====");
		tk.gravaPasso(lombriga.apresenta());
		for(int i = 0; i < ordens.length(); i++) {
			  switch(ordens.charAt(i)) {
			  case 'C':
				  lombriga.crescer();
				  break;
			  case 'M':
				  lombriga.mover();
				  break;
			  case 'V':
				  lombriga.virar();
				  break;
			  }
			  tk.gravaPasso(lombriga.apresenta());
		}
	}
	
	private AquarioLombriga criaLombriga(String instrucao) {
		int tamanhoAquario = Integer.parseInt(instrucao.substring(0,2));
		int tamanhoLombriga = Integer.parseInt(instrucao.substring(2,4));
		int posicaoInicialLombriga = Integer.parseInt(instrucao.substring(4, 6));
	
		return new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoInicialLombriga);
	}
}
