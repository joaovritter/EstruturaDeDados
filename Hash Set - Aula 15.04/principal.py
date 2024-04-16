import random

def main():
    hash_set = set()
    gerador = random.Random()
    for i in range(1000000):
        hash_set.add(gerador.randint(0, 999999))
    print("Feito")

    lista = list(hash_set)

    print("Feito passagem do hash para arraylist")

    lista.sort()

    print("Feito ordenacao")

if __name__ == "__main__":
    main()
