#include <iostream>
#include <ctime>
using namespace std;
#include "arvore.h"

int main (){
    Arvore *raiz = NULL;
    srand(time(NULL));
    
    // raiz = add (10,raiz);
    // raiz = add (20, raiz);
    // raiz = add (30,raiz);

    for (int i=0; i<100;i++){
        raiz = add (rand() %100, raiz);
    }


    // raiz = add (100,raiz);
    // raiz = add (150,raiz);
    // raiz = add (120,raiz);
    // raiz = add (70, raiz);

    // // showRED(raiz); //??
    // // showERD(raiz);
    // // showEDR(raiz);
    // mostrarArvore(raiz, 0);

    // cout << "A raiz possui " << contarElementos(raiz) << " Elementos" << endl;
    // cout << "A raiz possui " << contarPares(raiz) << " Elementos PARES" << endl;
    // cout << "A soma dos elementos: " << somarElementos(raiz) << endl;
    // cout << "A soma dos elementos: " << somarElementos(raiz) << endl;

    //  int valor;

    //  cout << "Digite o valor para pesquisar: " ;
    //  cin >> valor;

    //  cout << valor <<" esta ou na arvore? " << estaContido (valor,raiz) << endl;
    //  cout << valor <<" esta no nivel " << nivel (valor,raiz) << endl;

    //  raiz = remove (valor, raiz);
    //  cout << "Arvore apos delecao \n";
    //  mostrarArvore (raiz, 0);
      
    //  raiz = podar (raiz);
    //  cout << "Arvore apos poda \n";
        mostrarArvore (raiz, 0);
      
        cout << "Altura da arvore: " << altura (raiz) << endl;


    return 1;
}