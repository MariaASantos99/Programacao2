import static java.lang.System.*;
import java.util.*;
import java.io.*;
import p2utils.*;

public class NumberValue{
	
	public static void main (String[] args)throws IOException{
		File f = new File("numbers.txt");
		KeyValueList<String> dic = dicionario(f);
		boolean end = false;
		while(!end){
			try{
				Scanner sc = new Scanner(in);
				String[] frase = sc.nextLine().split(" ");
				int traducao = 0, i=0;
				while (i < frase.length){
					if(dic.contains(frase[i])){
						if(i==frase.length-1){
							traducao += Integer.parseInt(dic.get(frase[i]));
							i++;
						}else if(frase[i+1].equals("hundred")||frase[i+1].equals("thousand")||frase[i+1].equals("million")){
							if(frase[i+2].equals("hundred")||frase[i+2].equals("thousand")||frase[i+2].equals("million")){
								traducao += Integer.parseInt(dic.get(frase[i]))*Integer.parseInt(dic.get(frase[i+1]))*Integer.parseInt(dic.get(frase[i+2]));
								i+=3;
							}else{
								traducao += Integer.parseInt(dic.get(frase[i]))*Integer.parseInt(dic.get(frase[i+1]));
								i+=2;
							}
						}else{
							traducao += Integer.parseInt(dic.get(frase[i]));
							i++;
						}
					}else{
						out.printf("Number text \"%s\" does not exist in table!", frase[i]);
						exit(1);
					}	
				}
				print(frase, traducao);		
			}catch(NoSuchElementException e) {end=true;}
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
	
	public static void print(String[] s, int t){
		for (int i = 0; i < s.length; i++){
			out.print(s[i]+" ");
		}
		out.printf("-> %d\n", t);
		
	}
}

