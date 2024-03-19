#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <algorithm>

using namespace std;

#include "exercicio.h"

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
