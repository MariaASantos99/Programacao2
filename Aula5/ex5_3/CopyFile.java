/*
 * CopyFile.java
 * 
 * Copyright 2020 maria <maria@LAPTOP-QRF7J4PR>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.io.*;
import java.util.*;

public class CopyFile {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) throws IOException{
		if(args.length != 2){
			System.out.println("Usage: java -ea CopyFile <source-file> <destination-file>");
			System.exit(1);
		}
		File file1 = new File(args[0]);
		File file2 = new File(args[1]);
		if(!file1.exists()){
			System.out.printf("O ficheiro %s nao existe!\n",args[0]);
			System.exit(2);
		}
		if(file1.isDirectory()){
			System.out.printf("O ficheiro %s e um diretorio\n",args[0]);
			System.exit(3);
		}
		if(!file1.canRead()){
			System.out.printf("Nao e possivel ler o ficheiro %s\n",args[0]);
			System.exit(4);
		}
		
		if(file2.exists()){
			if(file2.isDirectory()){
				System.out.printf("O ficheiro %s e um diretorio\n",args[1]);
				System.exit(5);
			}
			if(!file2.canWrite()){
				System.out.printf("Nao e possivel escrever no ficheiro %s\n",args[1]);
				System.exit(6);
			}
			if(file2.equals(file1)){
				System.out.println("ERRO: input e output sao iguas");
				System.exit(7);
			}
			System.out.printf("O ficheiro %s ja existe!\n",args[1]);
			String r;
			do{
				System.out.println("Copiar para o ficheiro ja existente? (y/n)");
				r = sc.nextLine().toLowerCase();
			}while(!r.equals("y") && !r.equals("n"));
			
			if(r.equals("n"))System.exit(8);
		}
		
		copyFile(file1,file2);
	}
	
	public static void copyFile(File f1, File f2){
		assert f1!=null && f2!=null;
		try{
			Scanner scf = new Scanner(f1);
			PrintWriter pw = new PrintWriter(f2);
			while(scf.hasNextLine()){
				pw.println(scf.nextLine());
			}
			pw.close();
			scf.close();
		}catch(IOException  e){
			System.out.println("Erro a copiar para o ficheiro!");
			System.exit(9);
		}
	}
}

