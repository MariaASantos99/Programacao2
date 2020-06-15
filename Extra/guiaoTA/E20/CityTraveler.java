import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class CityTraveler{
  //...
	static HashTable<String> ht = new HashTable<>(20);
	public static void main(String[] args)throws IOException{
		if(args.length==0){
			out.println("Usage: java -ea CityTraveler <FICH1> <FICH2> ...");
			exit(1);
		}
		
		for(String city : args){
			File f = new File(city);
			Scanner scf = new Scanner(f);
			while(scf.hasNextLine()){
				String person = scf.nextLine();
				if(!person.equals("")){
					if(!ht.contains(person)){
						ht.set(person, city);
					}else{
						ht.set(person, ht.get(person)+" "+city);
					}
				}
			}
			scf.close();
		}
		print();
	}
	
	public static void print(){
		String[] keys = ht.keys();
		for(String key : keys){
			out.printf("%-15s: %s\n", key, ht.get(key));
		}
	}
}

