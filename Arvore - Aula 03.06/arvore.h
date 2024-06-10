#include <iostream>
#include <ctime>
using namespace std;
typedef struct no {
    int dado;
    struct no *esq;
    struct no *dir;

}Arvore;

//inserir
Arvore *add (int valor, Arvore *raiz){

    if (raiz){
        if (valor == raiz->dado){
            return raiz;
        }
        if (valor > raiz->dado){ //ir para esquerda
            raiz->esq = add (valor, raiz->esq);
        }
        else { // ir para direita
            raiz->dir = add (valor, raiz->dir);
        }
        return raiz;
    }
    else { //chegou nos nós folhas.
        Arvore *novo = (Arvore *)malloc (sizeof(Arvore));
        
        //depositar valores
        novo->dado = valor;
        novo->esq = NULL;
        novo->dir = NULL;

        //refaz encadeamento
        return novo;

    }
}
//mostrar
void showRED (Arvore *raiz){
    if (raiz){
        //visita raiz - R
        cout << raiz ->dado << endl;
        
        //vai pra esquerda - E
        showRED (raiz->esq);
        //vai pra direita - D
        showRED (raiz->dir);

    }
}

void showERD (Arvore *raiz){
    if (raiz){
        //vai pra esquerda - E
        showERD (raiz->esq);
        //visita raiz - R
        cout << raiz ->dado << endl;
        //vai pra direita - D
        showERD (raiz->dir);
    }
}

void showEDR (Arvore *raiz){
    if (raiz){
        //vai pra esquerda - E
        showEDR (raiz->esq);
        //vai pra direita - D
        showEDR (raiz->dir);
        //visita raiz - R
        cout << raiz ->dado << endl;
    }
}

void mostrarArvore (Arvore *raiz, int nivel){
    if (raiz){
        //ir tudo pra direita
        mostrarArvore (raiz->dir, nivel +1);

        //visitar raiz
        for (int i = 0; i<nivel ; i++){
            cout << "  ";
        }
        cout <<"(" << nivel << ")"<< raiz ->dado << endl;

        //ir tudo pra esquerda
        mostrarArvore (raiz->esq, nivel +1);
    }
}
//contar
int contarElementos (Arvore *raiz){
    if (raiz){
        return 1 + contarElementos (raiz->esq) + contarElementos(raiz->dir);
    }
    return 0;
}
int contarPares (Arvore *raiz){
    if (raiz){
        if (raiz->dado %2 ==0){
        return 1 + contarPares (raiz->esq) + contarPares(raiz->dir);
        }    
    }
    return 0;
}
//somar
int somarElementos (Arvore *raiz){
    if (raiz){
        return raiz->dado + somarElementos (raiz->esq) + contarElementos(raiz->dir);
    }
    return 0;
}
//esta contido
bool estaContido (int valor, Arvore *raiz){
    if (raiz){
        if (valor == raiz->dado) {
            return true;
        }
        if (valor < raiz->dado){//ir para esquerda
            return estaContido (valor, raiz->esq);
        }
        else { //ir para direita
            return estaContido (valor, raiz->dir);
        }
    }
    return false;
    
}
// qual o nivel
int nivel (int valor, Arvore *raiz){
    if (raiz){
        if (valor == raiz->dado) {
            return 0;
        }
        if (valor < raiz->dado){//ir para esquerda
            int respostaEmpilhamento = nivel (valor, raiz->esq);
            if (respostaEmpilhamento == -27){
                return respostaEmpilhamento;
            }
            else {
                return respostaEmpilhamento + 1;
            }
        }
        else { //ir para direita
            int respostaEmpilhamento = nivel (valor,raiz->dir);
            if (respostaEmpilhamento ==-27){
                return respostaEmpilhamento;
            }
            else {
                return respostaEmpilhamento + 1;
            }
        }
    }
    return -27;
    
}

//remover
Arvore *remove (int valor, Arvore *raiz){
    if (raiz){
        if (valor == raiz->dado){
            //delecao
            if (!raiz->esq && !raiz->dir){
                free (raiz);
                return NULL;
            }
            Arvore *novoPai;
            Arvore *temp;
            Arvore *p;
            if (raiz->esq){
                novoPai = raiz->esq;
                temp = novoPai->dir;
                novoPai->dir = raiz->dir;
                for (p = novoPai->dir; p->esq; p = p->esq);
                
                p->esq = temp;
                free (raiz);
                return novoPai;
            }
            else {
                novoPai = raiz->dir;
                free (raiz);
                return novoPai;
            }
        } 
        else if (valor < raiz->dado ){ //ir para esquerda
            raiz->esq = remove (valor, raiz->esq);
        }
        else { //ir para direita
            raiz->dir = remove (valor, raiz->dir);
        }
    }
    else {
        return NULL;
    }
}
Arvore *podar (Arvore *raiz){
    if (raiz){
        if (!raiz->esq && !raiz->dir){
            free(raiz);
            return NULL;
        }
        raiz->esq = podar (raiz->esq);
        raiz->dir = podar (raiz->dir);
        return raiz;
    }
    return NULL;
}
//calcular altura da arvore

int altura (Arvore *raiz){
    if (raiz){
        int altEsq = altura (raiz->esq);
        int altDir = altura (raiz->dir);
        if (altEsq > altDir){ 
            return 1 + altEsq;
        }
        return 1 + altDir;
    }
}
