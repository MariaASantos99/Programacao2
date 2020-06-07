//Maria Alves Santos 87965
import static java.lang.System.*;
import p2utils.*;
public class Palindrome{
	
	public static void main (String[] args) {
		if(args.length !=1){
			out.println("Usage: java -ea Palindrome <text>");
			exit(1);
		}
		
		Stack<Character> pilha = new Stack<Character>();
		Queue<Character> fila = new Queue<Character>();
		
		for (int i = 0; i < args[0].length(); i++){
			char c = args[0].charAt(i);
			
			if(Character.isLetterOrDigit(c)){
				pilha.push(c);
				fila.in(c);
			}
		}
		while(!pilha.isEmpty()){
			char c1 = Character.toLowerCase(pilha.top());
			char c2 = Character.toLowerCase(fila.peek());
			if(c1 != c2){
				out.printf("Text \"%s\" is not a palindrome!\n", args[0]);
				break;
			}else{
				pilha.pop();
				fila.out();
			}			
		}
		if(pilha.isEmpty()){out.printf("Text \"%s\" is a palindrome!\n", args[0]);}	
	}	
}

