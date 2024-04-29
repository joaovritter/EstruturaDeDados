from atleta import Atleta


def listar_nomes(lista):
    if lista:
        lista.sort(key=lambda atleta: atleta.nome)
        for item in lista:
            print(item)
    else:
        print("Nenhum atleta cadastrado!")


def listar_pontuacao(lista):
    if lista:
        lista.sort(key=lambda atleta: atleta.pontuacao)
        for pontos in lista:
            print(pontos)
    else:
        print("Nenhum atleta cadastrado!")


def cadastrar(hash_atleta, nome, apelido, fone, data_nascimento, pontuacao):
    print("CADASTRANDO ATLETA: ")
    jogador = Atleta(nome, apelido, fone, data_nascimento, pontuacao)
    if jogador not in hash_atleta:
        hash_atleta.add(jogador)
    else:
        print("Atleta já cadastrado")


def procurar_nome(hash_atleta, procura_nome):
    encontrado = False
    for jogador in hash_atleta:
        if jogador.nome == procura_nome:
            encontrado = True
            print(f"{procura_nome} encontrado!")
            break
    if not encontrado:
        print("Atleta não encontrado.")


def procurar_apelido(hash_atleta, procura_apelido):
    encontrado = False
    for jogador in hash_atleta:
        if jogador.apelido == procura_apelido:
            encontrado = True
            print(f"{procura_apelido} encontrado!")
            break
    if not encontrado:
        print("Atleta não encontrado.")


def remover_nome(hash_atleta, nome):
    removido = False
    for jogador in hash_atleta.copy():
        if jogador.nome == nome:
            hash_atleta.remove(jogador)
            removido = True
            print(f"Atleta removido: {jogador}")
            break
    if not removido:
        print("Atleta não encontrado.")


def remover_apelido(hash_atleta, apelido):
    removido = False
    for jogador in hash_atleta.copy():
        if jogador.apelido == apelido:
            hash_atleta.remove(jogador)
            removido = True
            print(f"Atleta removido: {jogador}")
            break
    if not removido:
        print("Atleta não encontrado.")


def main():
    hash_atleta = set()
    
    while True:
        print("\nDigite uma opção de acordo com o menu:\n")
        print("1- Listar Atletas (Nome ou pontuação)")
        print("2- Cadastrar Atleta")
        print("3- Procurar Atleta (Nome ou apelido)")
        print("4- Remover Atleta (Nome ou apelido)\n")

        op = int(input())
        
        if op == 1:
            print("Quer ver por 1- Nome ou 2- Pontuação? ")
            op_interna = int(input())
            if op_interna == 1:
                lista = list(hash_atleta)
                listar_nomes(lista)
            elif op_interna == 2:
                lista = list(hash_atleta)
                listar_pontuacao(lista)
        elif op == 2:
            print("CADASTRANDO ATLETA: ")
            nome = input("Digite o nome: ")
            apelido = input("Digite o apelido: ")
            fone = input("Digite o fone: ")
            data_nascimento = input("Digite a Data de Nascimento: ")
            pontuacao = input("Digite a Pontuação: ")
            cadastrar(hash_atleta, nome, apelido, fone, data_nascimento, pontuacao)
        elif op == 3:
            print("Quer procurar por 1- Nome ou 2- Apelido? ")
            op_interna = int(input())
            if op_interna == 1:
                procura_nome = input("Digite o Nome a ser procurado: ")
                procurar_nome(hash_atleta, procura_nome)
            elif op_interna == 2:
                procura_apelido = input("Digite o Apelido a ser procurado: ")
                procurar_apelido(hash_atleta, procura_apelido)
        elif op == 4:
            print("Quer remover por 1- Nome ou 2- Apelido? ")
            op_interna = int(input())
            if op_interna == 1:
                remove_nome = input("Digite o Nome a ser removido: ")
                remover_nome(hash_atleta, remove_nome)
            elif op_interna == 2:
                remove_apelido = input("Digite o Apelido a ser removido: ")
                remover_apelido(hash_atleta, remove_apelido)
        elif 5:
            print("Encerrando o programa...")
            return
        
        else:
            print("Tecla inválida. Digite novamente!")


if __name__ == "__main__":
    main()
