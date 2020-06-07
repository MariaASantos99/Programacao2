/*
 * ex1_5.java
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
public class ex1_5 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		double soma=0, media=0, n;
		int count=0;
		do{
			System.out.print("Numero: ");
			n = sc.nextDouble();
			count++;
			soma +=n;
		} while (n != 0);
		count -=1;
		media = soma/count;
		if (count==0)System.out.printf("Soma = %.4f \nLista vazia!\n",soma);
		else System.out.printf("Soma = %.4f\nMedia = %.4f",soma,media);
	}
}

