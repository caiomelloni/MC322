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
		super.caverna.imprimeCaverna();
		score.seMoveu();
		
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
		
		if (pegou) score.pegouOuro();
	}
	
	public void conectaScore(Score score) {
		this.score = score;
	}
	
	public void perdeuJogo() {
		System.out.println("Fim de jogo");
		caverna.resetarJogo(this);
	}

}
