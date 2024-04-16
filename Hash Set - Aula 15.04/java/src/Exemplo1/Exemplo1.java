package Exemplo1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Exemplo1 {
//	public static Boolean estaContido(int valor, ArrayList<Integer>lista) {
//		for (Integer item : lista) {
//			if (valor==item) {
//				return  true;
//			}	
//		}
//		return false;	
//	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String valor;
		
		HashSet<String> hash = new HashSet<String>();
		
		for (int i = 0; i < 6; i++) {
			System.out.println("Digite numero: ");
			valor = teclado.next();
			if (!hash.add(valor)) { //nao consegue adicionar o valor qnd ele ja esta contido
				System.out.println("Valor ja cadastrado!");
			}	
		
		}
		for (String item: hash) {
			System.out.println(item);
		}
		
		//ArrayList<Integer> lista= new ArrayList<Integer>();
//		for (int i = 0; i < 6; i++) {
//			System.out.println("Digite numero: ");
//			valor = teclado.nextInt();
//			if (!lista.contains(valor)) {
//				lista.add(valor);
//				lista.sort(null);
//			}	
//			else {
//				System.out.println("Valor ja cadastrado!");
//			}	
//		}
//		for (Integer item: lista) {
//			System.out.println(item);
//		}

		
		
	}		
}
