import p2utils.KeyValueList;
import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class TranslateNumbers{
	public static void main (String[] args)throws IOException {
		File f = new File("numbers.txt");
		KeyValueList<String> dic = dicionario(f);
		boolean end = false;
		while(!end){
			Scanner sc = new Scanner(in);
			String[] frase = sc.nextLine().split(" ");
			for (int i = 0; i < frase.length; i++){
				String traducao;
				if(dic.contains(frase[i]))traducao = dic.get(frase[i]);
				else traducao = frase[i];
				System.out.print(traducao+" ");			
			}
			System.out.println();		
		}		
	}
	
	public static KeyValueList<String> dicionario(File f){
		KeyValueList<String> dic = new KeyValueList<>();
		try{
			Scanner scf = new Scanner(f);
			while(scf.hasNextLine()){
				String[] info = scf.nextLine().split(" - ");
				if(!dic.contains(info[1]))dic.set(info[1],info[0]);
			}
			scf.close();
		}catch(Exception e){err.println("ERRO: " + e.getMessage());}
		return dic;
	}
}
