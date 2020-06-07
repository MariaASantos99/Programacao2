//Maria Santos 87965
import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import p2utils.SortedKeyValueList;

public class CountWords2{

  public static void main(String[] args) {
    SortedKeyValueList<Integer> counts = new SortedKeyValueList<>();

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      // Using a try-with-resources:
      try (Scanner scf = new Scanner(fin)) {
        while (scf.hasNextLine()) { // Processa cada linha
          String line = scf.nextLine();
          // Divide a linha em "palavras", considerando como separador
          // qualquer sequência de 1 ou mais carateres não alfabéticos:
          String[] palavras = line.split("[^\\p{IsAlphabetic}]+");
          // (Sobre expressões regulares usadas no split: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)

          for (int i = 0; i < palavras.length; i++) { // Processa cada palavra
            // Completar...
            int count=0;
			if(counts.contains(palavras[i].toLowerCase()))count = counts.get(palavras[i].toLowerCase());
			counts.set(palavras[i].toLowerCase(),count+1);
          }
        }
      }
      catch (Exception e) {
        err.println("ERRO: " + e.getMessage());
      }
    }
    out.println(counts.toString("Results:\n", ";\n", "\nEnd"));
    out.println(counts.toString()); // mesma lista, outro formato
    mostFrequent(counts);
  }

  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(SortedKeyValueList<Integer> counts) {
    // Completar...
    
    int freq = 0;
    String key = "";
    int totalCount = 0;
    String[] words = counts.keys();
    for (int i = 0; i < words.length; i++){
		int c = counts.get(words[i]);
		if(c>freq){
			key = words[i];
			freq = c;			
		}
		totalCount += c;
	}
	double fr = 100.0*freq/totalCount;
	out.printf("Most frequent: %s (%.2f%%)\n", key, fr);
  }
}

