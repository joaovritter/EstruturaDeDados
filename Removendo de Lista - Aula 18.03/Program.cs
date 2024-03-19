// See https://aka.ms/new-console-template for more information
using System.Runtime.ExceptionServices;

Console.WriteLine("Hello, World!");

void exibir (List<int> lista)
{
    foreach (var item in lista)
    {
        Console.WriteLine(item);
    }
                // ou (evita fazer esse)
    //for (int i =0; i <lista.Count; i++)
    //{
    //    Console.WriteLine(lista[i]);
    //}



}

List<int> lista = new List<int>();
Random gerador = new Random();

int valor, qtdNumeros=10;
for (int i = 0; i<qtdNumeros; i++)
{
    valor = gerador.Next(100);

    if (!lista.Contains(valor)) { 
        lista.Add(valor);
        lista.Sort();
    }
}

Console.WriteLine("Tamanho da lista: " + lista.Count);
exibir(lista);

Console.Write("Digite um valor para exclusão: ");
valor = int.Parse(Console.ReadLine()); //int.Parse() passa de int para string
lista.Remove(valor);

Console.WriteLine("Tamanho da lista apos remoção: " + lista.Count);
exibir(lista);
