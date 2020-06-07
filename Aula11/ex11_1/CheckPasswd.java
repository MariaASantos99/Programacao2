import static java.lang.System.*;
import java.util.*;
import java.io.*;
import p2utils.*;

public class CheckPasswd{
	
	public static void main (String[] args)throws IOException {
		if(args.length != 1){
			err.printf("Usage: java -ea CheckPasswd <password file>");
			exit(1);
		}
		Scanner sc = new Scanner(in);
		KeyValueList<String>pass = new KeyValueList<>();
		File f = new File(args[0]);
		Scanner scf = new Scanner(f);
		try(scf){
			while(scf.hasNextLine()){
				String[] info = scf.nextLine().split(" ");
				if(info.length != 2)throw new IOException("ERRO: Malformed password file");
				pass.set(info[0], info[1]);
			}
		}catch(Exception e){exit(2);}
		
		boolean end = false;
		while(!end){
			try{
				out.print("Username: ");
				String user = sc.next();
				out.print("Password: ");
				String passw = sc.next();
				if(!pass.contains(user))out.println("Authentication failed");
				else if(pass.get(user).equals(passw))out.println("Authentication successful");
				else out.println("Authentication failed");
				out.println();
			}catch(NoSuchElementException e) {end=true;}
		}
		
		
	}
}

