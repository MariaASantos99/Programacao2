import static java.lang.System.*;
import java.util.*;
public class TestComplex {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double r=0, i=0;
		if(args.length>2)System.out.println("Erro, sintaxe incorreta!");
		else if(args.length==2){
			r = Double.parseDouble(args[0]);
			i = Double.parseDouble(args[1]);
		}else{		
			System.out.print("Re: ");
			r= sc.nextDouble();
			System.out.print("Im: ");  
			i= sc.nextDouble();
		}
		Complex a = new Complex(r,i);
		
		// Vamos usar métodos do objeto a
		out.println("(" + a.real() + " + " + a.imag() + "i)");
		out.println("  parte real = " + a.real());
		out.println("  parte imaginaria = " + a.imag());
		out.println("  modulo = " + a.abs());
		out.printf("  argumento =  %2.2f\n", a.arg());
	}

}
