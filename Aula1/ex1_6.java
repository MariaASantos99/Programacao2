/*
 * ex1_6.java
 * 
 * Copyright 2020 Maria Alves Santos <mariaalvessantos@l230210-ws06.ua.pt>
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
public class ex1_6 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		int numero = (int)(Math.random()*(100+1));
		System.out.println(numero);
		int n, count=0;
		do{
			count++;
			System.out.printf("[Tentativa %d]:",count);
			n = sc.nextInt();
			if(n<numero){
				System.out.printf("Valor %d é menor do que o numero misterio!\n",n);
			}else if(n>numero){
				System.out.printf("Valor %d é maior do que o numero misterio!\n",n);
			}
		}while(n!=numero);
		System.out.printf("Acertou, a sua pontuacao e %d!\n",count);
	}
}

