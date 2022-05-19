package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna = null;
	
	public void initCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void inserirComandos(String comandos[], Controle controle) {
		
		for (int i = 0; i < comandos.length; i++) {
			inserirComponente(comandos[i], controle);
		}
	}
	
	// formato do comando: x,y,funcao - exemplo: 1,1,P
	private void inserirComponente(String comando, Controle controle) {
		int x = comando.charAt(0) - 49;
		int y = comando.charAt(2) - 49;
		char funcao = comando.charAt(4);
		
		Componente comp;
		
		switch(funcao) {
		case 'P':
			Heroi heroi = new Heroi(x, y, "RODOLFO");
			comp = heroi;
			controle.conectaHeroi(heroi);
			break;
		case 'B':
			comp = new Buraco(x, y);
			break;
		case 'W':
			comp = new Wumpus(x, y);
			break;
		case 'O':
			comp = new Ouro(x, y);
			break;
		default:
			comp = new Vazio(x,y);
		}
		
		
		caverna.conectaComp(comp, x, y);
		comp.conectaCaverna(caverna);
	}
}
