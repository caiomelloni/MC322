package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	private boolean possuiFlecha = true;
	private boolean flechaEquipada = false;
	private String nome;
	private Score score;
	
	public Heroi(int x, int y, String nome) {
		super(x, y, 'P');
		this.nome = nome;
	}
	
	public void equiparFlecha() {
		if (possuiFlecha) {
			flechaEquipada = true;
			possuiFlecha = false;
		}
		super.caverna.imprimeCaverna();
	}

	public String getNome() {
		return nome;
	}

	public void mover(int y, int x) {
		// só atira se a flecha estiver equipada
		
		int oldX = super.getX();
		int oldY = super.getY();
		
		super.setX(x);
		super.setY(y);
		super.caverna.moverHeroi(this, oldY, oldX, score);
		
		if(!(x == 0 && y == 0 && score.possuiOuro())) score.seMoveu(); 
		super.caverna.imprimeCaverna();
		score.placarAtual();
		System.out.println("=====");
		
	}
	
	void atirar() {
		Random random = new Random();        
		int ganhou = random.nextInt(2); // 1 ganhou e 0 perdeu

		if(!flechaEquipada || ganhou == 0) 
		{
			score.perdeuBuracoOuWumpus();
	    	perdeuJogo();
			return;
		}
		flechaEquipada = false;
		score.usouFlecha();
			
		caverna.matarWumpus(getY(), getX(), this);
		score.matouWumpus();

		
	}
	
	public void pegaOuro() {
		boolean pegou = super.caverna.pegaOuro(super.getY(), super.getX());
		
		if (pegou) {
			score.pegouOuro();
			
			for (int coluna = super.getX() - 1; coluna <= super.getX() + 1; coluna++) {
				if(!Controle.coordenadasValidas(super.getY(), coluna)) continue;
				super.caverna.espalharFedor(super.getY(), coluna);
			}
			
			for (int linha = super.getY() - 1; linha <= super.getY() + 1; linha++) {
				if(!Controle.coordenadasValidas(linha, super.getX())) continue;
				super.caverna.espalharFedor(linha, super.getX());
			}
			
			
		}
		super.caverna.imprimeCaverna();
	}
	
	public void conectaScore(Score score) {
		this.score = score;
	}
	
	public void perdeuJogo() {
		caverna.imprimeCaverna();
		System.out.println("=====");
		caverna.resetarJogo(this);
	}

	public void sairCaverna() {
		if(score.possuiOuro()) {
			caverna.imprimeCaverna();
			score.saiuDaCaverna();
			System.out.println("=====");
			caverna.resetarJogo(this);
		}
		
	}

	public void sairJogo() {
		caverna.imprimeCaverna();
		score.saiuDoJogo();
		System.out.println("=====");
		caverna.resetarJogo(this);
	}

}
