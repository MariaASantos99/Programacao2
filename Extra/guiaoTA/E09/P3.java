import static java.lang.System.*;

public class P3 {

	public static void main(String[] args) {
		for (int i = 1; i < args.length ; i+=2){
			out.printf("\"%s\" is prefixed by \"%s\" -> ",args[i-1],args[i]);
			if(isPrefix(args[i-1],args[i],0))out.println("true");
			else out.println("false");
		}
		
	}
	
	public static boolean isPrefix(String s, String p,int i){
		if(p.equals(""))return true;
		if(s.length()< p.length() || s.equals(""))return false;		
		if(i==p.length()-1)return true;
		if(s.charAt(i) != p.charAt(i))return false;
		return isPrefix(s,p,i+1);
	}

}

