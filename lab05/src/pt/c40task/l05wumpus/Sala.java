package pt.c40task.l05wumpus;

public class Sala {
	private Componente componente;
	private boolean mostraComponente = false;
	private Componente heroi = null;
	private boolean possuiWumpus = false;
	
	public Sala(Componente componente) {
		if(componente.ehHeroi()) {
			inserirHeroi(componente);
			this.componente = new Vazio(componente.getX(), componente.getY());
		} else {			
			if (componente.ehWumpus()) {
				possuiWumpus = true;
			}
			this.componente = componente;
		}
		
	}
	
	public void colocarFedor() {
		Fedor fedor = new Fedor(componente.getY(), componente.getX());
		if (componente.ehBrisa() || componente.ehVazio()) {
			componente = fedor;
		}
	}
	
	public void colocarBrisa() {
		Brisa brisa = new Brisa(componente.getY(), componente.getX());
		if (componente.ehVazio()) {
			componente = brisa;
		}
	}
	
	public boolean saquearSala() {
		if(!componente.ehOuro()) return false;
		componente = new Vazio(componente.getX(), componente.getY());
		return true;
	}
	
	public void matarWumpus(int x, int y) {
		if(componente.ehWumpus()) {
			possuiWumpus = false;
		}
	}
	
	public char getComponenteFuncao() {
		boolean possuiHeroi = heroi != null;
		
		if (possuiHeroi && (componente.ehVazio() || componente.ehBrisa() || componente.ehFedor())) {
			return heroi.getComponenteFuncao();
		}
		
		if (componente.ehWumpus() && !possuiWumpus) {
			if (possuiHeroi) return heroi.getComponenteFuncao();
			
			return '#';
		}

		if(mostraComponente) {
			return componente.getComponenteFuncao();
		}
		
		return '-';		
	}
	
	//não é usado na primeira inserção
	public void inserirHeroi(Heroi heroi, Score score) {
		this.heroi = heroi;
		mostraComponente = true;
		
		if (componente.ehBuraco()) {
			score.perdeuBuracoOuWumpus();
			heroi.perdeuJogo();
		} else if(componente.ehWumpus()) {
			heroi.atirar();
		}
		
		if(heroi.getX() == 0 && heroi.getY() == 0) {
			heroi.sairCaverna();
		}
	}
	
	public void inserirHeroi(Componente heroi) {
		this.heroi = heroi;
		mostraComponente = true;
		
	}
	
	public void esconderComponente() {
		mostraComponente = false;
		
		if(componente.ehWumpus()) {
			possuiWumpus = true;
		}
	}
	
	public void retirarHeroi() {
		heroi = null;
	}
	
	public boolean hasHero() {
		return heroi != null;
	}
}
