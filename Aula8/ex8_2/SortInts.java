import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts{
  public static void main(String[] args) throws IOException {
     SortedListInt sli = new SortedListInt();
     if(args.length == 0){
		 out.println("Usage: java -ea SortInts file1 ...");
		 exit(1);
	 }
	 for(int k=0; k< args.length; k++){
		 File f = new File(args[k]);
		 Scanner scf = new Scanner(f);
		 while(scf.hasNextLine()){
			 String palavra = scf.next();
			 int num;
			 try{
				 num = Integer.parseInt(palavra);
				 sli.insert(num);
			 }catch(NumberFormatException e){
				 
			 }
		 }
		 scf.close();
	 }
	 print(sli);
  }
  //imprime e remove da lista
  public static void print(SortedListInt list){
	  while(!list.isEmpty()){
		  out.println(list.first());
		  list.removeFirst();
	  }
  }
}


