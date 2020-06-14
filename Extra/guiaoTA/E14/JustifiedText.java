import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class JustifiedText{
	public static void main(String[] args)throws IOException{
		if(args.length != 2){
			System.out.println("Usage: java -ea JustifiedText <NUM-COLUMNS> <FILE>");
			exit(1);
		}
		int n=-1;
		try{
			n = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			out.printf("ERROR: argument %d is not an integer number!", n);
			exit(1);
		}
		try{
			String fic = new String(args[1]);
			File f = new File(fic);
			Scanner scf = new Scanner(f);
			Queue<String> fila = new Queue<>();
			while(scf.hasNextLine()){
				String[] words = scf.nextLine().split(" ");
				if(words.length != 0){
					for (int i = 0; i < words.length; i++){
						fila.in(words[i]);
					}				
				}else fila.in("\n");
			}
		}catch(IOException e){
			out.printf("ERROR in file \"%s\": read failure!", args[1]);
			exit(1);
		}
	}
	
	public static void print(Queue<String> fila){
		assert !fila.isEmpty();
		out.print(fila.peek());
		fila.out();
		while(!fila.isEmpty()){
			out.print(" " + fila.peek());
			fila.out();
		}
		out.println();
	}
}

