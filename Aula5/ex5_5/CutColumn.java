import java.io.*;
import java.util.*;
public class CutColumn {
	
	public static void main (String[] args)throws IOException {
		if(args.length!=2){
			System.err.print("Usage: java -ea CutColumn <source-file> <column-number>");
			System.exit(0);
		}
		File f = new File(args[0]);
		int n = Integer.parseInt(args[1]);
		if(!f.isFile()){
			System.out.println("Nao e um ficheiro");
			System.exit(1);
		}
		else if(f.isDirectory()){
			System.out.println("E um diretorio");
			System.exit(2);
		}
		else if(!f.canRead()){
			System.out.println("Nao se consegue ler o ficheiro");
			System.exit(3);
		}else{
			Scanner scf = new Scanner(f);
			int linhas=0;
			while(scf.hasNextLine()){
				String line = scf.nextLine();
				linhas++;
			}
			scf.close();
			scf = new Scanner(f);
			String [] s = new String[linhas];
			int count=0;
			while(scf.hasNextLine()){
				String[] lines = scf.nextLine().split("[ \t+]");
				if(lines.length <= n-1)s[count++]=" ";
				else s[count++]=lines[n-1];
			}
			scf.close();
			for (int i = 0; i < s.length; i++)
			{
				System.out.println(s[i]);
			}
			
		}
	}
}
