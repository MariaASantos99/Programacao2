import static java.lang.System.*;

public class AllDivisors{
	public static void main(String[] args){
		if(args.length == 0 || args.length > 1)System.out.println("Usage: java -ea AllDivisors <NUM>");
		allDivisors(Integer.parseInt(args[0]),1);
	}
	
	public static void allDivisors(int num, int count){
		String s = String.format("%"+count+"s","");
		out.println(s + num );
		for (int i = num-1; i >1 ; i--){
			if(num%i==0)allDivisors(i,count+3);		
		}
		
	}
}

