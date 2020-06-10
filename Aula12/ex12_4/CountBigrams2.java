import static java.lang.System.*;
import java.util.*;
import java.io.IOException;
import java.io.File;
import p2utils.HashTable;

public class CountBigrams2{
	static Scanner sc = new Scanner(in);
	public static void main(String[] args) {
		HashTable<HashTable<Integer>> ht = new HashTable<>(100000); // Usamos hash table!

		for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
			File fin = new File(args[a]);
			analyseText(fin, ht); // atualiza contagens de bigramas
		}
    
		printCounts(ht);
		out.println();
    
		boolean sair = false;
		do{
			try{
				out.print("Word? (Ctrl+D to stop) ");
				String chave = sc.nextLine();
				if(ht.contains(chave)) {
					out.printf("After \"%s\" \n", chave);
					mostFrequent(chave,ht);
				}else {out.printf("Word \"%s\" never occurred! \n", chave);}
			}catch(NoSuchElementException e) {sair = true;}
		}while(!sair);
	}

	// Read input text file word by word and count occurences of bigrams
	static void analyseText(File fin, HashTable<HashTable<Integer>> ht) {
		try {
			Scanner scf = new Scanner(fin);
			scf.useDelimiter("[^\\p{IsAlphabetic}]+");
			// ^ Isto serve para especificar que o separador de "tokens" no scanner
			// será qualquer sequência de 1 ou mais carateres não alfabéticos.
			// Assim, cada token devolvido por scf.next() é uma palavra no sentido
			// mais convencional: uma sequência composta apenas de letras!

			String prevWord = null; // serve para guardar a palavra anterior

			while (scf.hasNext()) { // Processa cada palavra
				// palavra atual: é lida do scanner e normalizada:
				String currWord = scf.next().toLowerCase();
				if(prevWord != null){
					if(ht.contains(prevWord)){
						if(ht.get(prevWord).contains(currWord))
							ht.get(prevWord).set(currWord, ht.get(prevWord).get(currWord)+1);
						else 
							ht.get(prevWord).set(currWord, 1);
					}else{
						HashTable<Integer> counts = new HashTable<>(100000);
						counts.set(currWord, 1);
						ht.set(prevWord, counts);
					}
				}
				prevWord = currWord;
			}
			scf.close();
		}catch (IOException e) {
			err.printf("ERROR: %s\n", e.getMessage());
			exit(1);
		}
	}

  // Print each key (bigram) and its count
  static void printCounts(HashTable<HashTable<Integer>> counts) {
	String[] keys = counts.keys();
	Arrays.sort(keys);
	for (int i = 0; i < keys.length; i++) {
		out.println(keys[i]+": "+counts.get(keys[i]));
	}
  }
  
	static void mostFrequent(String key, HashTable<HashTable<Integer>> ht){
		assert ht.contains(key);
		mostFrequent(ht.get(key));
	}
	
	// Find and print the key with most occurrences
	// and its relative frequency.
	static void mostFrequent(HashTable<Integer> counts) {
		String[] keys = counts.keys();
		String mostFrequent = null;
		int count = 0, max=0;
		for (int i = 0; i < keys.length; i++){
			int value = counts.get(keys[i]);
			if(max < value){
				max = value;
				mostFrequent = keys[i];
			}
			count += value;
		}
		double fr = ((double)max/(double)count)*100;
		out.printf("Number of keys: %d\n", keys.length);
		out.printf("Most frequent key: \"%s\" (%d/%d = %.2f%%)\n", mostFrequent, max, count, fr);
	}
}
