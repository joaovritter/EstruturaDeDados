typedef struct no {
    int dado;
    struct no *prox;
} Lista;

void exibir(Lista *lista){
    Lista *p;
    for (p = lista; p; p = p->prox) {
        cout << p->dado << endl;
    }
}

int contar(Lista *lista){
    Lista *p;
    int qtd = 0;
    for (p = lista; p; p = p->prox) {
        qtd++;
    }
    return qtd;
}

bool localizar(int valor, Lista *lista) {
    Lista *p;
    
    for (p = lista; p; p = p->prox) {
        if (valor == p->dado)
            return true;
    }
    return false;
}


Lista *inserir(int valor, Lista *lista) {
    //alocar memoria
    Lista *novo;
    novo = (Lista*)malloc(sizeof(Lista));

    //depositar valores
    novo->dado = valor;
    novo->prox = NULL;

    //engatar novo na sua posicao
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
