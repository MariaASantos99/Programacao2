// TODO: Determine whether a or b do not represent an integer
// by catching the NumberFormatException. If either one is not an integer,
// use the value 0 when computing the sum.

public class Numbers{
	public int add(String a, String b)throws NumberFormatException{
		int x, y;
		try{
			x = Integer.parseInt(a);
		}catch(NumberFormatException e){
			x=0;
		}
		try {
			y = Integer.parseInt(b);
		}catch(NumberFormatException e){
			y=0;
		}
		return x + y;
	}
}
