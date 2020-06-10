import static java.lang.System.*;
import java.util.*;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;
import p2utils.HashTable;

public class ListGroups {
	
	public static void main (String[] args) {
		if(args.length != 1){
			err.printf("Usage: java -ea CheckGroups Group-File\n");
			exit(1);
		}
		
		File fin = new File(args[0]);
		
		HashTable<String> ht = new HashTable<>(200);
		loadFile(fin, ht);
		print(ht);
	}
	
	public static void loadFile(File f , HashTable<String> ht){
		try{
			Scanner scf = new Scanner(f);
			scf.nextLine();
			while(scf.hasNextLine()){
				String[] info = scf.nextLine().split("\t");
				if(ht.contains(info[1])){
					ht.set(info[1], ht.get(info[1])+", "+info[0]);
				}else {ht.set(info[1], info[0]);}
			}
			scf.close();
		}catch(IOException e) {
			out.printf("%s: Error: %s (O sistema nao conseguiu localizar o ficheiro especificado)", f, f);
			exit(2);
		}
	}
	
	public static void print(HashTable<String> ht){
		String[] chaves = ht.keys();
		for(int i = 0; i<chaves.length; i++){
			out.printf("%s: [%s] \n", chaves[i], ht.get(chaves[i]));
		}
		
	}
}

