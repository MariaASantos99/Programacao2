/*
 * ex1_7.java
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

import java.util.*;
import java.io.*;
public class ex1_7 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) throws IOException{
		String filename1,filename2;
		System.out.print("Ficheiro 1: ");
		filename1 = sc.nextLine();
		System.out.print("Ficheiro 2: ");
		filename2 = sc.nextLine();
		File file1 = new File(filename1);
		File file2 = new File(filename2);
		if(!file1.exists())System.out.println("O ficheiro nao existe!");
		else if(!file1.isFile())System.out.println("Nao e um ficheiro!");
		else if(!file1.canRead())System.out.println("Nao e possivel ler o ficheiro!");
		else if(file1.isDirectory())System.out.println("O ficheiro e um diretorio!");
		else{
			Scanner scf = new Scanner(file1);
			int line = 0;
			while(scf.hasNextLine()){
				String linha = scf.nextLine();
				line++;
			}
			scf.close();
			String[] info = new String[line];
			scf = new Scanner(file1);
			int lines = 0;
			while(scf.hasNextLine()){
				String linha = scf.nextLine();
				info[lines++] = linha;
			}
			scf.close();
			if(file2.exists()){
				System.out.println("Ficheiro ja existe, tem a certeza que quer elimina-lo?");
				String res = sc.next();
				if(res.equals("s")){
					if(file2.delete()){System.out.printf("Ficheiro %s eliminado com sucesso\n",filename2);
					}else{ System.out.println("Erro!");	}			
				}
			}
			if(file2.createNewFile()){
				System.out.printf("Ficheiro %s criado com sucesso!\n",filename2);
				PrintWriter wr = new PrintWriter(filename2);
				for(String i : info){wr.write(i+"\n");}
				wr.close();
				System.out.println("Copia feita com sucesso!");	
			}
			
		}
	}
}

