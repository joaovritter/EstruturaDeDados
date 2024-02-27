#include <iostream>
#include <ctime>

using namespace std;

typedef struct nodo {
    int valor;
    struct nodo *prox;
} Pilha;

Pilha *remover(Pilha *topo) {
    //verificar se existe
    if (!topo) return topo;
    //isolar o topo
    Pilha *lixo = topo;
    //atualizar o novo topo
    topo = topo->prox;
    //liberar memoria
    free(lixo);
    //retornar o novo topo
    return topo;
}

Pilha *inserir(int valor, Pilha *topo) {
    //alocar memoria
    Pilha *novo = (Pilha *)malloc(sizeof(Pilha));

    //depositar valores dos parametros na estrutura criada
    novo->valor = valor;
    //engatar
    novo->prox = topo;
    //retornar
    return novo;

    
}

void imprimir(Pilha *topo) {
    if (!topo) return;
    
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        cout << i->valor << endl;
    }
}

int contarElementos(Pilha *topo) {
    if (!topo) return 0;
    int quantidade = 0;
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        quantidade++;
    }
    return quantidade;
}

bool estaContido(int valor, Pilha *topo) {
    if (!topo) return 0;
    
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        if (valor == i->valor){
            return true;
        }
    }
    return false;
}


int main() {
    Pilha *pilha = NULL;

    int quantidadeNumeros;
    cout << "Quantos numeros quer armazenar na pilha? ";
    cin >> quantidadeNumeros;
    int valor;

    srand(time(NULL));
    for (; quantidadeNumeros > 0; quantidadeNumeros--){
        valor = rand() % 100;
        if (valor % 2 == 0) { //se for par vai inserir na pilha o valor
            pilha = inserir(valor, pilha);
        }
        else { // se for impar vai remover da um da pilha, no caso par pq so entrou par antes
            pilha = remover (pilha);
        }
    }
    imprimir(pilha);
    cout << "Pilha com um total de " << contarElementos(pilha) << " elementos" << endl;

    return 1;
}