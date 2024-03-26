package DesafioListas;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Desafio {

	public static void main(String[] args) {
		Random gerador = new Random();
		Scanner teclado = new Scanner(System.in);
		List<List> listaGenerica = new ArrayList<List>();
		
		System.out.println("Quantidade listas que tu quer: ");
		int tamanhoListaGenerica = teclado.nextInt();
		System.out.println("Quantidade listas que tu quer: ");
		int tamanhoListaInterna = teclado.nextInt();
		int valor;
		for (int i = 0;i < tamanhoListaGenerica; i++ ) {
			listaGenerica.add(new ArrayList<Integer>());
			for (int j=0;j< tamanhoListaInterna; j++) {
				valor = gerador.nextInt(50);
				if (!listaGenerica.get(i).contains(valor)) {
					listaGenerica.get(i).add(valor);
					listaGenerica.get(i).sort(null);
				}
			}	
		}
		for (int i =0; i <listaGenerica.size();i++) {
			System.out.println("Exibindo a Lista: " +(i+1));
			for (int j =0; j<listaGenerica.get(i).size();j++) {
				System.out.println(listaGenerica.get(i).get(j));
			}
		}
		
		for (int i = 0; i < listaGenerica.size(); i++) {
		    for (int j = 0; j < listaGenerica.get(i).size(); j++) {
		         valor = (int) listaGenerica.get(i).get(j);
		        boolean encontrado = false; //determina se o valor atual é encontrado em outras listas
		        for (int k = 0; k < listaGenerica.size(); k++) { //verifica se o valor atual ta em outras listas além da atual (i).
		            if (k != i && listaGenerica.get(k).contains(valor)) { // se for encontrado em outra lista
		                encontrado = true; //retorna true e para
		                break;
		            }
		        }
		        if (!encontrado) {
		        	System.out.println("Valores isolados: "); //se nao, é unico e printa
		            System.out.println(valor);
		        }
		    }
		}

	}

}
