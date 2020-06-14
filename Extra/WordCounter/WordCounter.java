import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
   Reads a text file, line by line,
   counts the number of words per line,
   prints out each line of the poem,
   preceded by number of the number of words in that line.
*/
public class WordCounter{
   public static void main(String[] args) throws FileNotFoundException
   {
      // Set up the input and output file names
      String inputFileName = "Peter.txt";
      String outputFileName = "output.txt";

      // Construct the Scanner and PrintWriter objects
      File f1 = new File(inputFileName);
      Scanner scf = new Scanner(f1); 
      File f2 = new File(outputFileName);
      PrintWriter wr = new PrintWriter(f2);
      int count=0,j=0;
      while(scf.hasNextLine()){
         String linha = scf.nextLine();
         count++; 
      }
      scf.close();
      scf = new Scanner(f1);
      String [] lines = new String[count];
      while(scf.hasNextLine()){
         String linha = scf.nextLine();
         lines[j++]=linha;
         
      }
      scf.close();
      int [] nwords = new int[lines.length];
      for (int i = 0; i < lines.length; i++){
         if(lines[i].length()==0)nwords[i]=0;
         else{
            String[] palavras = lines[i].split(" ");
            nwords[i] = palavras.length;
         }
      }
      
      for (int i = 0; i < lines.length; i++){
         wr.printf("%d   %s\n",nwords[i],lines[i]);
      }
      wr.close();
      
   }
}
