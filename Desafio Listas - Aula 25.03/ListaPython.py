import random

def elemento_repetido(lista_generica, elemento):
    contagem = 0
    for lista_interna in lista_generica:
        if elemento in lista_interna:
            contagem += 1
            if contagem > 1:
                return True
    return False

def main():
    lista_generica = []
    print("Digite quantos elementos possui a lista generica:")
    generica = int(input())
    print("Digite quantos elementos possui a lista interna:")
    interna = int(input())

    for i in range(generica): 
        lista_generica.append([])
        for j in range(interna):  
            valor = random.randint(0, 19)
            if valor not in lista_generica[-1]:
                lista_generica[-1].append(valor)
                lista_generica[-1].sort()

    for i, lista_interna in enumerate(lista_generica, 1): #Mostra todos elementos da lista generica, começando em 1
        print("Exibindo Lista:", i)
        for j, valor in enumerate(lista_interna, 1): #Mostra os inteiros da lista interna
            print(f"Valor {j}: {valor}")

    unicos = []
    for lista_interna in lista_generica:
        for elemento_atual in lista_interna:
            if not elemento_repetido(lista_generica, elemento_atual):
                unicos.append(elemento_atual)

    print("Elementos únicos:")
    for elemento in unicos:
        print(elemento)

if __name__ == "__main__":
    main()
