import static java.lang.System.*;

public class Levenshtein
{
	public static void main(String[] args) {
		if (args.length != 2) {
			out.println("Uso: java -ea Levenshtein <palavra1> <palavra2>");
			exit(1);
		}

		int d = distancia(args[0], args[1]);
		out.printf("\"%s\" <-> \"%s\" = %d\n", args[0], args[1], d);
	}
  
	public static int distancia(String p1, String p2){
		if(p2.length()==0)return p1.length();
		else if(p1.length()==0)return p2.length();
		else{
			String s1 = p1.substring(1,p1.length());
			String s2 = p2.substring(1,p2.length());
			char c1 = p1.charAt(0);
			char c2 = p2.charAt(0);
			if(c1==c2) return distancia(s1,s2);
			else return 1+min(distancia(s1,p2),distancia(p1,s2),distancia(s1,s2));
		}
	}
	
	public static int min(int a, int b, int c){
		if(a<=b && a<=c)return a;
		else if(b<=a && b<=c)return b;
		else return c;
	}
  

}
