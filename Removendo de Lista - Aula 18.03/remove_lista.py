import random

def exibir(lista):
    for item in lista: 
        print (item)

lista = []

qtd_numeros= 10
for i in range(0, qtd_numeros):
    valor = random.randint(0,100)
    if (valor not in lista):
        lista.append(valor)
        lista.sort()

exibir (lista)

valor = int(input ('entre com o valor para remocao: '))
lista.remove(valor)
print ("Tamanho da lista: ", lista.count())
exibir (lista)