import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
  private static Scanner sin = new Scanner(in);
  public static void main(String[] args) {
    char jogador1 = 'X';
    char jogador2 = 'O';
    int lin,col, ptsX=0, ptsO=0,emp=0, njgs=0;
    JogoDoGalo jogo;
    do{
		if(njgs % 2 ==0)jogo = new JogoDoGalo(jogador1, jogador2);
		else jogo = new JogoDoGalo(jogador2, jogador1);
		out.printf("Jogo #%d\n", ++njgs);
		jogo.mostraTabuleiro();
		while (!jogo.terminado()) {
			
			do{
				out.print("(lin col):");
				lin = sin.nextInt();
				col = sin.nextInt();
				if(!jogo.jogadaValida(lin,col))System.out.println("ERROR: jogada invalida");	
			}while(!jogo.jogadaValida(lin,col));
			jogo.jogada(lin, col);
			jogo.mostraTabuleiro();
		}
		out.println();
		if (jogo.terminado()) {
		  out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
		  out.println();
		  if(jogo.ultimoJogador() == 'X')ptsX++;
		  else ptsO++;
		} else {
		  out.println("Jogo empatado!");
		  out.println();
		  emp++;
		}
		print(ptsX,ptsO, emp);
	}while(njgs!=10 && ptsX !=3 && ptsO!=3);
  }
  
	public static void print(int pX, int pO, int emp){
		out.printf("Jogador | Vitorias | Derrotas | Empates\n");
		out.printf("   X    |    %d     |    %d     |    %d  \n", pX, pO, emp);
		out.printf("   O    |    %d     |    %d     |    %d  \n", pO, pX, emp);
		out.println();
	}
}

