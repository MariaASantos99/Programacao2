import static java.lang.System.*;
import java.util.*;
import java.io.*; 
public class ListRec {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		if(args.length > 1){
			err.println("Uso: java -ea ListRec [<ficheiro>]");
			exit(1);
		}
		File fin;
		if(args.length==1)
			fin = new File(args[0]);
		else 
			fin = new File(".");
		
		if(!fin.exists()){
			err.println("ERRO: o diretorio \""+args[0]+"\"nao existe");
			exit(2);
		}
		lsR(fin);
	}
	
	public static void lsR(File path){
		assert path!=null && path.exists();
		
		out.println(path.getPath());
		if(path.isDirectory() && path.canRead()){
			File[] list = path.listFiles();
			for (int i = 0; i < list.length; i++)
				lsR(list[i]);		
		}
	} 	
}

