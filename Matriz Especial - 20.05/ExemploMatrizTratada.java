package Exemplo1;

import java.util.HashSet;

public class ExemploMatrizTratada {

	public static void criar (int matriz[][], int linha, int coluna) {
		matriz = new int[linha][coluna];
	
		for (int i=0 ; i<linha ; i++) {
			for (int j=0 ; j<coluna ; j++) {
				matriz[i][j]=0;
			}
		}	
	}
	
	public static void exibir (int matriz[][]) {
		for (int i=0 ; i<matriz.length ; i++) {
			for (int j=0 ; j<matriz[i].length ; j++) {
				System.out.print(matriz[i][j]+ "\t");	
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int tamLinha = 5;
		int tamColuna = 5;
		int matrizEspecial[][]= new int [tamLinha][tamColuna];
		ExemploMatrizTratada.criar(matrizEspecial, 10,10);
		
		matrizEspecial[0][0]= 5;
		matrizEspecial[2][3]= 5;
		matrizEspecial[3][4]= 5;
		
		ExemploMatrizTratada.exibir (matrizEspecial);
		
		HashSet<Celula> tabelaHash = new HashSet<Celula>();
		
		Celula.transformaMatrizEmHash (matrizEspecial, tabelaHash);
		System.out.println("Exibindo");
		Celula.exibeMatrizEmHash (tabelaHash);
		
		//fazendo o contrario
		
		int[][] matriz2 = new int[Celula.qtdLinhas][Celula.qtdColunas];
		
		Celula.transformaHashEmMatriz(matriz2, tabelaHash);
		System.out.println("Exibindo");

		ExemploMatrizTratada.exibir(matriz2);

	}

}
