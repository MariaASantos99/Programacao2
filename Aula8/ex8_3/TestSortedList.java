import static java.lang.System.*;
import p2utils.*;

public class TestSortedList{
  // Apresenta
  // * os números dados na linha de comando por ordem crescente;
  // * os restantes argumentos por ordem lexicográfica.  (FALTA FAZER!)
  // Utiliza duas listas ordenadas para fazer isto.
public static void main(String[] args) {
	// Uma lista para os números:
	SortedList<Double> numbers = new SortedList<Double>();
	// Outra lista para as restantes strings:
	SortedList<String> words = new SortedList<String>();
		
	for (int i=0; i<args.length; i++) {
		try{
			// Converte args[i] para número e guarda na lista:
			numbers.insert( Double.valueOf(args[i]) );
		}catch(NumberFormatException e){
			words.insert(args[i]);
		}
	}
	// Escrever a lista dos números (destruindo-a):
	out.printf("Numbers (%b):\n", numbers.isSorted());
	while (!numbers.isEmpty()) {
		out.println(numbers.first());
		numbers.removeFirst();
	}
	// Escrever a lista do resto:
	out.printf("Rest(%b):\n", words.isSorted());
	while(!words.isEmpty()){
		out.println(words.first());
		words.removeFirst();
	}
}

}

