import java.io.*;
import static java.lang.System.*;
public class ListDir {
	public static void main (String[] args) throws IOException {
		if(args.length ==0){
			File f = new File(".");
			assert f.isDirectory(): "Erro do programador";
			File[] files = f.listFiles();
			printInfo(files);
		}else if (args.length ==1){
			File f = new File(args[0]);
			assert f.isDirectory(): "O ficheiro passado como argumento deve ser um diretorio";
			File[] files = f.listFiles();
			printInfo(files);
		}else{
			err.println("Devera passar apenas um diretorio como argumento");
			exit(0);
		}
	}
	
	public static void printInfo(File[] f) throws IOException{
		for (int i = 0; i < f.length; i++){
			//verifica se é um ficheiro ou um diretório
			if(f[i].isFile())out.print("F");
			else if(f[i].isDirectory())out.print("D");
			//verifica se se pode ler
			if(f[i].canRead())out.print("R");
			else out.print("-");
			//verifica se se pode escrever
			if(f[i].canWrite())out.print("W");
			else out.print("-");
			//imprimir o formato do diretorio
			out.println(" "+f[i].getPath());
		}
		
	}
}

