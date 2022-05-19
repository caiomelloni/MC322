package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna = null;
	private int qtdBuraco = 0;
	private int qtdOuro = 0;
	private int qtdHeroi = 0;
	private int qtdWumpus = 0;
	
	public void initCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void inserirComandos(String comandos[], Controle controle) {
		
		for (int i = 0; i < comandos.length; i++) {
			inserirComponente(comandos[i], controle);
		}
		caverna.imprimeCaverna();
		System.out.println("Player: " + controle.getPlayerName() + "\nScore: 0");
		if (qtdBuraco < 2) System.out.println("número insuficiente de buracos");
	}
	
	// formato do comando: x,y,funcao - exemplo: 1, 1, P
	private void inserirComponente(String comando, Controle controle) {
		int x = comando.charAt(0) - 49;
		int y = comando.charAt(3) - 49;
		char funcao = comando.charAt(6);
		
		Componente comp;
		
		switch(funcao) {
		case 'P':
			Heroi heroi = new Heroi(x, y, "RODOLFO");
			comp = heroi;
			controle.conectaHeroi(heroi);
			qtdHeroi++;
			break;
		case 'B':
			comp = new Buraco(x, y);
			qtdBuraco++;
			break;
		case 'W':
			comp = new Wumpus(x, y);
			qtdWumpus++;
			break;
		case 'O':
			qtdOuro++;
			comp = new Ouro(x, y);
			break;
		default:
			comp = new Vazio(x,y);
		}
		
		if (comp.ehHeroi() && qtdHeroi > 1) return;
		if (comp.ehWumpus() && qtdWumpus > 1) return;
		if (comp.ehBuraco() && qtdBuraco > 3) return;
		if (comp.ehOuro() && qtdOuro > 1) return;
		
		caverna.conectaComp(comp, x, y);
		comp.conectaCaverna(caverna);
	}
}
