using System;
using System.Collections.Generic;
using System.Linq;

class Desafio
{
    static void Main(string[] args)
    {
        List<List<int>> listaGenerica = new List<List<int>>();
        Random gerador = new Random();
        Console.WriteLine("Digite quantos elementos possui a lista generica:");
        int generica = int.Parse(Console.ReadLine());
        Console.WriteLine("Digite quantos elementos possui a lista interna:");
        int interna = int.Parse(Console.ReadLine());

        for (int i = 0; i < generica; i++)
        {
            listaGenerica.Add(new List<int>());
            for (int j = 0; j < interna; j++)
            {
                int valor = gerador.Next(20);
                if (!listaGenerica[i].Contains(valor))
                {
                    listaGenerica[i].Add(valor);
                    listaGenerica[i].Sort();
                }
            }
        }

        for (int i = 0; i < listaGenerica.Count; i++)
        {
            Console.WriteLine("Exibindo Lista: " + (i + 1));
            for (int j = 0; j < listaGenerica[i].Count; j++)
            {
                Console.WriteLine("Valor " + (j + 1) + ": " + listaGenerica[i][j]);
            }
        }

        List<int> unicos = new List<int>();
        for (int i = 0; i < listaGenerica.Count; i++)
        {
            for (int j = 0; j < listaGenerica[i].Count; j++)
            {
                int elementoAtual = listaGenerica[i][j];
                if (!ElementoRepetido(listaGenerica, elementoAtual))
                {
                    unicos.Add(elementoAtual);
                }
            }
        }

        Console.WriteLine("Elementos unicos:");
        foreach (int elemento in unicos)
        {
            Console.WriteLine(elemento);
        }
    }

    private static bool ElementoRepetido(List<List<int>> listaGenerica, int elemento)
    {
        int contagem = 0;
        for (int i = 0; i < listaGenerica.Count; i++)
        {
            if (listaGenerica[i].Contains(elemento))
            {
                contagem++;
                if (contagem > 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
