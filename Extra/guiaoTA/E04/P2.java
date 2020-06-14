import static java.lang.System.*;

public class P2{
  public static void main(String[] args){
	  for (int i = 0; i < args.length; i++){
		  		  out.printf("%s -> %s\n", args[i],invertDigits(args[i],"",0));
	  }
	  
  }
  
  public static String invertDigits(String s, String num, int i){
	  if(i > s.length()-1)return "";
	  char c = s.charAt(i);
	  if(Character.isDigit(c)){
		  num = c + num;
		  if(i==s.length()-1 || !Character.isDigit(s.charAt(i+1))){
			  return num + invertDigits(s,"", i+1);
		  }
		  return invertDigits(s,num,i+1);
	  }else return c + invertDigits(s,"", i+1);
  }

}
