import java.util.*;
import static java.lang.System.*;
public class MDC {
	public static void main (String[] args) {
		if(args.length != 2){
			out.println("USO: java -ea MDC <a> <b>");
			exit(0);
		}
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		out.printf("mdc(a,b)=%d",mdc(a,b));
		
	}
	
	public static int mdc(int a, int b){
		assert (a>0 && b>=0);
		if(b==0)return a;
		else return mdc(b,a%b);
	}
}

