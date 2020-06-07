import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class FindFile{
	public static void main (String[] args) {
		if(args.length ==0 || args.length > 2){
			out.println("Uso: java -ea FindFile <padrao> [<dir>]");
			exit(1);
		}
		
		File file = null;
		if(args.length == 2)file = new File(args[2]);
		else file = new File(".");
		Files(file,args[0]);
	}
	
	public static void Files(File f, String s){
		if(f.getName().indexOf(s)>=0)out.printf("%s\n",f.getPath());
		if(f.isDirectory() && f.canRead()){
			File [] path = f.listFiles();
			for(int i=0; i<path.length; i++)Files(path[i], s);
		}
	}
}

