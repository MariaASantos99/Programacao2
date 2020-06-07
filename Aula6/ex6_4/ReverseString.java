import static java.lang.System.*;
import java.util.*;
public class ReverseString {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		//~ assert reverse("hello").equals("olleh");
		//~ assert reverse("follow").equals("wollof");
		//~ assert reverse("x").equals("x");
		//~ assert reverse("").equals("");
		String s="";
		if(args.length == 0)s="";
		else if(args.length <= 1) s= args[0]; 
		else out.println("Erro");
		
		out.printf("\"%s\" -> \"%s\"",s,reverse(s));
	}
	
	public static String reverse(String s){
		int n = s.length();
		if(n<=1)return s;
		else return reverse(s.substring(1,n))+s.substring(0,1);
	} 
}

