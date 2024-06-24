package arquivoGrafo;

import java.util.ArrayList;

class Grafo {
    public int matrizAdjacencia[][];
    public ArrayList<String> vertices;
    public int qtdVertices;
    public int qtdArestas;

    public Grafo(ArrayList<String> vertices) {
        this.vertices = new ArrayList<>(); //lista das cidades
        this.vertices.addAll(vertices); //adiciona todas cidades
        this.qtdVertices = vertices.size();//qnd chama qtd vertices vai mostrar size
        this.qtdArestas = 0; //inicia em 0 e dps no inserirArestaSimetrica vai aumentando
        this.matrizAdjacencia = new int[this.qtdVertices][this.qtdVertices]; //matriz quadrada das cidades
        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.matrizAdjacencia[i][j] = 0; //inicia em 0
            }
        }
    }

    public void inserirArestaSimetrica(String origem, String destino) { //vai e volta       
        int indiceOrigem = this.vertices.indexOf(origem); //pega o indice
        int indiceDestino = this.vertices.indexOf(destino); //pega o indice
        if (origem.equalsIgnoreCase(destino) || indiceOrigem == -1 || indiceDestino == -1) {
            return; //se origem for igual a destino ou nao existir na lista (-1) retorna
        }

        if (this.matrizAdjacencia[indiceOrigem][indiceDestino] == 0) {
            this.matrizAdjacencia[indiceOrigem][indiceDestino] = 1;
            this.qtdArestas++; //se nao exitir conexao adiciona aresta de origem para destino
        } 
        if (this.matrizAdjacencia[indiceDestino][indiceOrigem] == 0) {
            this.matrizAdjacencia[indiceDestino][indiceOrigem] = 1;
            this.qtdArestas++; //se nao exitir conexao adiciona aresta de destino para origem
        }
    }

    public void show() { //mostrar
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(this.vertices.get(i) + "\t\t\t"); //percorre e mostra
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matrizAdjacencia[i][j] != 0) {
                    System.out.print(this.vertices.get(j) + "\t\t\t");
                }
            }
            System.out.println();
        }
    }

    public int mostrarGrau(String cidade) { //soma das conexões de entrada e saída.
        int indice = this.vertices.indexOf(cidade); //busca o indice da cidade na lista de vertices
        if (indice == -1) return -1; //se nao tiver na lista, retorna
        int qtd = 0;
        for (int i = 0; i < this.qtdVertices; i++) { // percorre todas cidades e as q tiver conexao com o indice soma 1 na entrada e saida
            if (this.matrizAdjacencia[indice][i] != 0) { //se o indice for diferente de 0 conta uma aresta
                qtd++; //cidade-entrada
            }
            if (this.matrizAdjacencia[i][indice] != 0) {
                qtd++; //saida-cidade
            }
        }
        return qtd; 
    }
}

