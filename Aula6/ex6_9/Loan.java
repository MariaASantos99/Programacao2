import static java.lang.System.*;
import java.util.*;
public class Loan {
	
	public static void main (String[] args) {
		if(args.length != 4){
			out.println("USO: java -ea Loan n M T P");
			exit(0);
		}
		int n = Integer.parseInt(args[0]);
		double m = Double.parseDouble(args[1]);
		double t = Double.parseDouble(args[2]);
		double p = Double.parseDouble(args[3]);
		
		out.printf("(iterativo)d(%d) = %.4f\n",n,divIte(n,m,t,p));
		out.printf("(recursivo)d(%d) = %f",n,divRec(n,m,t,p));
	}
	
	public static double divIte(int n, double m, double t, double p){
		double divida=m;
		for(int i = 1; i<=n; i++){
			divida += divida*(t/100)-p;
		}
		return divida;
	}
	public static double divRec(int n,double m, double t, double p){
		double divida;
		if(n==0)divida = m;
		else divida = divRec(n-1,m,t,p)+divRec(n-1,m,t,p)*(t/100)-p;
		return divida;
		
	}
}
