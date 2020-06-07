import static java.lang.System.*;
import java.util.Arrays;

public class Ngrams {

  public static void main(String[] args) {
    int N = 3;
    switch (args.length) {
    case 1:
      break;
    case 2:
      try {
        N = Integer.parseInt(args[1]);
      }
      catch (NumberFormatException e) {
        err.printf("Second argument must be a number.\n");
        exit(1);
      }
      break;
    default:
      out.println("USO: java -ea Ngrams ABC [N]");
      exit(1);
    }
    String[] a;
    // Crie a função allNgrams e altere a invocação abaixo...
    a = allNgrams(args[0],N);
    //~ a = all3grams(args[0]);
    out.println(Arrays.toString(a));
  }

  // Gera todos os arranjos de 3 símbolos escolhidos do alfabeto alpha.
  public static String[] all3grams(String alpha) {
    int l = alpha.length();
    String[] arr = new String[l*l*l];
    int n = 0;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        for (int k = 0; k < l; k++) {
          arr[n] = "" +  alpha.charAt(i) + alpha.charAt(j) + alpha.charAt(k);
          n++;
        }
      }
    }
    assert n == arr.length;
    return arr;
  }

  // Gera todos os N-gramas de símbolos escolhidos do alfabeto alpha.
  public static String[] allNgrams(String alpha, int n) {
    assert n >= 0;
    int ns = alpha.length();
    String []arr = {""}; //criar um array com nada resultado no caso base
    if(n>0){
		String []sarr = allNgrams(alpha, n-1);
		arr = new String [ns * sarr.length];
		int j = 0;
		for(int k = 0; k<sarr.length; k++){
			for(int i = 0; i<ns; i++){
				arr[j++] = "" + sarr[k] + alpha.charAt(i);

			}
		}
		assert j==arr.length;
	}
   return arr;
  }
}

