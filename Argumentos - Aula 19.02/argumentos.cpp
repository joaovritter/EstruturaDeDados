#include <iostream>
#include <string>
#include <fstream>
using namespace std;
// bool pq queremos dar return true ou false somente
bool procurarPalavraNoAquivo(string palavra, char *nomeArquivo) { //stg palavra é a palavra a ser procurada. ponteiro para char representando o nome do arquivo de busca
    ifstream procuradorArquivo; //tipo de arquivo para leitura, procuradorArquivo é um objeto da classe ifstream.
    procuradorArquivo.open(nomeArquivo); 

    if (!procuradorArquivo) { // se nao abrir procuradorArquivo manda a msg e retorna falso
        cout << nomeArquivo << "Arquivo nao localizado." << endl;
        return false;
    }
    	
	//le o arquivo capturando as frases
	string linha;
	while (!procuradorArquivo.eof()) { // loop q continua enquanto nao chega no final do arquivo , eof - end of file (vai ler todas linhas)
		getline(procuradorArquivo,linha); //getline (le linha inteira) do arquivo e armaneza em linha
		if (linha.find(palavra) != string::npos) {// verifica se a palavra q ta procurando ta na linha atual.
        //string::npos é posição inválida ou não encontrada em uma string
        //se find nao retornar string::npos a palavra foi encontrada
            procuradorArquivo.close(); // fecha o arquivo antes para nao corromper
            return true;
        }
	}
	procuradorArquivo.close(); // fecha novamente se o loop terminar sem encontrar a palavra e retorna falso
    return false;
}

int main(int quantidadeArgumentos, char** vetorArgumentos) { // vetorArgumentos: contem os argumentos passados para o programa
    
    if (quantidadeArgumentos != 3) {
        cout << "Quantidade de argumentos invalida\n";
        exit(0);
    }
                                    // vetorArgumentos [0] é o nome do executavel
    cout << "Arquivo de busca: " << vetorArgumentos[1] << endl; // vai mostrar o 2 argumento passado para o programa 
    cout << "Palavra de busca: " << vetorArgumentos[2] << endl; //vai mostrar o 3 argumento passado para o programa

    if (procurarPalavraNoAquivo(vetorArgumentos[2], vetorArgumentos[1])) { // se retorna true a palavra foi encontrada
        cout << "Palavra encontrada\n";
    } else {
        cout << "Palavra nao encontrada\n";
    }

    return 1;
}