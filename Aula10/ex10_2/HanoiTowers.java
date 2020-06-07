//Maria ALves Santos 87965
import static java.lang.System.*;
import java.util.Scanner;
import p2utils.Stack;

public class HanoiTowers{
	private Stack<Integer> A = new Stack<Integer>();
	private Stack<Integer> B = new Stack<Integer>();
	private Stack<Integer> C = new Stack<Integer>();
	private int moves =0;
	public HanoiTowers(int disc){
		for (int i = disc; i>0; i--){
			A.push(i);
		}
	}
	
	public void moveDisc(Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> ajuda, int discs){
		if(discs>0){
			moveDisc(origem, ajuda, destino, discs-1);
			moveOneDisc(origem, destino);
			printInfo();
			moveDisc(ajuda, destino, origem, discs-1);
		}
	}
	
	public void moveOneDisc(Stack<Integer> origem, Stack<Integer> destino){
		moves++;
		destino.push(origem.top());
		origem.pop();
	}
	
	public void solve(){
		printInfo();
		moveDisc(A, C, B, A.size());
		
	}
	
	public void printInfo(){
		out.printf("After %d mover: \n", moves);
		out.printf("A: %s \n", A.reverseToString());
		out.printf("B: %s\n", B.reverseToString());
		out.printf("C: %s \n", C.reverseToString());
	}
	
	public int numberOfMoves(){return this.moves;}
}
