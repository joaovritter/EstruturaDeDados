#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct no {
   valor a ser armazenado, int
   ponteiro para o próximo nó na lista
} Lista;

void exibir(passa a lista){ // pra exibir nao precisa de retorno
    cria um ponteiro para percorrer toda a lista e exibindo
    for comeca no inicio da lista até diferente de nulo, dps mostra os dados da lista
}

int contar(passa a lista){ contao número de elementos e retorna esse valor.
    percorrer a lista contando
    retorna o valor

bool localizar(passa a lista e valor a ser localizado) { se localizou true 
    percorre a lista, se o valor for igual ao da lista retorna true
    se nao, false
}


Lista *inserir(passa o valor) { inserindo ordenado
cria a nova variavel(ex: novo) do tipo da lista
alocar memoria necessaria para a variavel 

alocar os valores:
  atribuir valor no dado do novo nó
  que ainda não está conectado a nenhum proximo nó


engatar novo na sua posicao:
    dois ponteiros para percorrer a lista, um na frente e o outro de retaguarda
    for comeca no inicio da lista (retaguarda é nulo pq o p é o inicio) até diferente de nulo
        ordenando:
            se o valor ja existir, limpa onde ele ta e retorna a lista modificada
    Lista *p, *pR;
    for (pR = NULL, p = lista ; p ; pR = p, p = p->prox) {
        if (valor == p->dado) {
            free(novo);
            return lista; 
        }
        if (valor < p->dado) {
            //achei a posicao
            break;
        }
    }
    //inserir na primeira posicao
    if (p == lista) {
        novo->prox = p;
        return novo;
    }
    //inserir na ultima posicao
    if (!p) {
        pR->prox = novo;
        return lista;
    }
    //inserir em alguma posicao do meio
    pR->prox = novo;
    novo->prox = p;
    return lista;
}

void emComum (Lista *lista, Lista *lista2){
    Lista *p, *p2;
    for (p = lista; p; p=p->prox){
        for (p2=lista2; p2 ; p2=p2->prox){
            if (p->dado == p2->dado){
                cout << p->dado << endl;
            }
        }
    }

}

void naoComum(Lista *lista1, Lista *lista2) {
    Lista *p1, *p2;
    bool encontrado;

    // Percorre a lista 1
    for (p1 = lista1; p1; p1 = p1->prox) {
        encontrado = false;

        // Verifica se o número de lista1 está presente em lista2
        for (p2 = lista2; p2; p2 = p2->prox) {
            if (p1->dado == p2->dado) {
                encontrado = true;
                break;
            }
        }

        // Se o número não foi encontrado em lista2, imprime-o
        if (!encontrado) {
            cout << p1->dado << endl;
        }
    }

    // Percorre a lista 2
    for (p2 = lista2; p2; p2 = p2->prox) {
        encontrado = false;

        // Verifica se o número de lista2 está presente em lista1
        for (p1 = lista1; p1; p1 = p1->prox) {
            if (p2->dado == p1->dado) {
                encontrado = true;
                break;
            }
        }

        // Se o número não foi encontrado em lista1, imprime-o
        if (!encontrado) {
            cout << p2->dado << endl;
        }
    }
}


int main() {
    Lista *lista = NULL;
    int qtd = 5;
    srand(time(NULL));

    Lista *lista2 = NULL;
    int qtd2 = 5;
    srand(time(NULL));

    for (; qtd > 0; qtd--) {
        lista = inserir(rand() % 20, lista);
    }
    cout << "Tamanho da lista 1: " << contar(lista) << endl;
    exibir(lista);

    for (; qtd2 > 0; qtd2--) {
        lista2 = inserir(rand() % 20, lista2);
    }
    cout << "Tamanho da lista 2: " << contar(lista2) << endl;
    exibir(lista2);

    cout << "Numeros em comuns das duas listas: " << endl;
    emComum(lista, lista2);

    cout << "Numeros nao comuns das duas listas: " << endl;
    naoComum(lista, lista2);

    return 0;
}
