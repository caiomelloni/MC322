package pt.c40task.l05wumpus;

public class AppWumpus {
 
   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      
      String[] comandos = new String[cave.length];
      
      for (int l = 0; l < cave.length; l++) {
         comandos[l] = cave[l][0] + ", " + cave[l][1] + ", " + cave[l][2];
      }
      
      if (arquivoMovimentos != null) {
    	  String movements = tk.retrieveMovements();//string contínua de ordens
    	  modoLeitura(comandos, movements, tk);
      } else {
    	  modoInterativo(comandos, tk);
      }
      
      tk.stop();
   }
  
   private static void modoInterativo(String[] comandos, Toolkit tk) {
		Montador montador = new Montador();
		Controle controle = new Controle();
		Caverna caverna = new Caverna();
		montador.initCaverna(caverna);
		montador.inserirComandos(comandos, controle);
		controle.ativaModoInterativo(tk);
   }
   
   private static void modoLeitura(String[] comandos, String movements, Toolkit tk) {
		Montador montador = new Montador();
		Controle controle = new Controle();
		Caverna caverna = new Caverna();
		montador.initCaverna(caverna);
		montador.inserirComandos(comandos, controle);
		controle.ativaModoLeitura(movements, tk);
   }

}
