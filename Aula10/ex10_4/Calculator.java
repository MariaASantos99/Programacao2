import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.Stack;

public class Calculator{
	public static void main(String[] args){
		Scanner sc = new Scanner(in);
		Stack<Double> calc = new Stack<Double>();
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] lines = line.split(" ");
			for (int i = 0; i < lines.length; i++){
				try{
					calc.push(Double.parseDouble(lines[i]));
					out.printf("STACK: %s\n", calc.reverseToString());
				}catch(NumberFormatException e){
					assert calc.size()>=2: "Cant operate with 1 number";
					String s = lines[i];
					double a = calc.top();
					calc.pop();
					double b = calc.top();
					calc.pop();
					switch(s){
						case "*": 
							calc.push(b*a); 
						break;
						case "+":
							calc.push(b+a);
						break;
						case "/":
							calc.push(b/a);
						break;
						case "-":
							calc.push(b-a);
						break;
						default:
							err.println("Invalid operator");
						break;
					}
					out.printf("STACK: %s\n", calc.reverseToString());					
				}
			}	
		}
	}
}
