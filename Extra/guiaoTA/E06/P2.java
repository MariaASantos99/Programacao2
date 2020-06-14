import static java.lang.System.*;

public class P2{
	public static void main(String[] args){
		for (int i = 0; i < args.length; i++){
			out.printf("\"%s\" contains %d pairs of consecutive equal characters\n", args[i], countPairs(args[i],0));
		}
		
	}
	
	public static int countPairs(String s, int i){
		if(i >=s.length()-1)return 0;
		if(s.charAt(i) ==s.charAt(i+1))return 1+countPairs(s,i+1);
		else return 0+countPairs(s,i+1);
	}
	
	//outra formula
	//~ public static int countPairs(String s, int i){
		//~ int count=0;
		//~ if(i >=s.length()-1)return 0; 
		//~ if(s.charAt(i) ==s.charAt(i+1)){
			//~ count = 1 + countPairs(s,i+1);
		//~ }else count = 0 + countPairs(s,i+1);
		//~ return count;
	//~ }
}

