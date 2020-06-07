import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class FilterLines2{
  public static void main(String[] args) throws IOException{
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);

    LinkedList<String> cl = new LinkedList<String>();
    LinkedList<String> media = new LinkedList<String>();
     
    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) {
      String line = sf.nextLine();
      if(line.length() < 20)cl.addFirst(line);
      else if(line.length()>=20 && line.length()<40)media.addLast(line);
      else cl.addLast(line);
    }
    sf.close();
	
    cl.print();
    media.print();
  }

}
