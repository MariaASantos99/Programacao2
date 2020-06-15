import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class Restaurante {
	static HashTable<Integer> ht = new HashTable<>(1000);
	static Queue<HashTable<Integer>> fila = new Queue<HashTable<Integer>>();
	public static void main(String[] args)throws IOException {
		if(args.length==0){
			out.println("Comida em stock:");
			exit(1);
		}
		
		for (String arg : args){
			File f = new File(arg);
			Scanner scf = new Scanner(f);
			while(scf.hasNextLine()){
				String[] line = scf.nextLine().split(" ");
				if(line[0].equals("entrada:")){
					if(!ht.contains(line[1]))ht.set(line[1],1);
					else ht.set(line[1], ht.get(line[1])+1);
				}else if(line[0].equals("saida:")){
					HashTable<Integer> t = new HashTable<>(1000);
					for(int i = 1; i < line.length; i++){
						String[] pedido = line[i].split(":");
						t.set(pedido[0], Integer.parseInt(pedido[1]));
					}
					fila.in(t);
				}
			}
			scf.close();
			HashTable<Integer> order = fila.peek();
			while(canServed(order)){
				if(!fila.isEmpty()){
					atualiza(order);
					out.printf("Refeicao servida: %s\n", printOrder(order));
				}
				order = fila.peek();
			}
		}
		printStock();
		pendentes();
	}
	
	public static void  atualiza(HashTable<Integer> h){
		String[] keys = h.keys();
		for(String key : keys){
			ht.set(key, ht.get(key)-h.get(key));
			if(ht.get(key) == 0)ht.remove(key);
		}
		fila.out();		
	}
	
	
	public static boolean canServed(HashTable<Integer> order){
		String[] keys = order.keys();
		boolean serve = true;
		for(String key : keys){
			if(!ht.contains(key)){
				serve = false;
				break;
			}else if(ht.get(key) < order.get(key)){
				serve = false;
				break;
			}
		}
		return serve;
	}
	
	public static String printOrder(HashTable<Integer> order){
		String s="";
		String[] keys = order.keys();
		for(String key : keys){
			s += key+":"+order.get(key)+" ";
		}
		return s;
	}
	
	public static void printStock(){
		String[] keys = ht.keys();
		out.println("Comida em stock:");
		for(String key : keys){
			out.printf("  %s: %d\n", key, ht.get(key));
		}
	}
	
	public static void pendentes(){
		while(!fila.isEmpty()){
			out.printf("Refeicao pendente:  %s\n", printOrder(fila.peek()));
			fila.out();
		}
	}
}
