package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);

   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      Tabuleiro tabuleiro = new Tabuleiro();
      tk.writeBoard("Tabuleiro inicial", tabuleiro.board());
 
      for (int l = 0; l < commands.length; l++) {
    	  tabuleiro.executarJogada(commands[l]);
    	  String jogada = "source: " + commands[l].substring(0, 2) + "; target: " + commands[l].substring(3);
    	  tk.writeBoard(jogada, tabuleiro.board());
      }
      
      tk.stop();
   }
 
}
