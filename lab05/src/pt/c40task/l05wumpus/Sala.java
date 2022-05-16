package pt.c40task.l05wumpus;

public class Sala {
	private Componente componente;
	private boolean mostraComponente = false;
	private Componente heroi = null;
	
	public Sala(Componente componente) {
		if(componente.ehHeroi()) {
			inserirHeroi(componente);
			this.componente = new Vazio(componente.getX(), componente.getY());
		} else {			
			this.componente = componente;
		}
		
	}
	
	public void escondeComponente() {
		mostraComponente = false;
	}
	
	public void deixaComponenteVisivel() {
		mostraComponente = true;
	}
	
	public char getComponenteFuncao() {
		if (heroi != null) {
			return heroi.getComponenteFuncao();
		}

		if(mostraComponente) {
			return componente.getComponenteFuncao();
		}
		
		return '-';		
	}
	
	public void inserirHeroi(Componente heroi) {
		this.heroi = heroi;
	}
	
	public void retirarHeroi() {
		this.heroi = null;
	}
}
