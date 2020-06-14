import static java.lang.System.*;

public class UnitaryFractionSum{
	public static void main(String[] args){
		System.out.printf("%s/%s = %s\n",args[0],args[1],fraction(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
	}
	
	public static String fraction(int num, int den){
		int d=0;
		while(d<=(den/num) && (den/num)>d- 1)d+=1;
		if(num==1)return num+"/"+den;
		else if(den % num ==0) return "1/"+num;
		else{
			num = num*d-den;
			den = den*d;
			return "1/"+d+" + "+fraction(num,den);
		}
	}
}


