package Exemplo1;

import java.util.HashSet;
import java.util.Objects;

public class Celula {
	int linha;
	int coluna;
	int valor;
	static int qtdLinhas;
	static int qtdColunas;
	
	public Celula (int linha, int coluna, int valor) {
		this.linha =linha;
		this.coluna = coluna;
		this.valor = valor;	
	}

	@Override
	public String toString() {
		return "Celula [linha=" + linha + ", coluna=" + coluna + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coluna, linha);
	}
	

	public static void transformaMatrizEmHash (int matriz[][], HashSet<Celula>tabelaHash) {
		for (int i=0 ; i<matriz.length ; i++) {
			for (int j=0 ; j<matriz[i].length ; j++) {
				if (matriz[i][j] !=0) {
					tabelaHash.add(new Celula (i, j, matriz[i][j]));
				}
			}
		}
		Celula.qtdLinhas = matriz.length;
		Celula.qtdColunas = matriz[0].length;
	}
	
	public static void transformaHashEmMatriz (int matriz2 [][], HashSet<Celula>tabelaHash){

		    for (int i = 0; i < Celula.qtdLinhas; i++) {
		        for (int j = 0; j < Celula.qtdColunas; j++) {
		            matriz2[i][j] = 0;
		        }
		    }
		    for (Celula ponto : tabelaHash) {
		        matriz2[ponto.linha][ponto.coluna] = ponto.valor;
		    }
		}

	
	public static void exibeMatrizEmHash (HashSet<Celula> tabelaHash) {
		System.out.println("Matriz ["+Celula.qtdLinhas+"] ["+qtdColunas+"]");
		for (Celula ponto : tabelaHash) {
			System.out.println(ponto);
		}
	}
		
		
	
	
	
	
	
}
