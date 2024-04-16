using System;

public class Principal
{

    public static void main(String[] args)
    {
        HashSet<Double> hash = new HashSet<Double>();
        Random gerador = new Random();
        for (Double i = 0.0; i < 1000000; i++)
        {
            hash.Add(gerador.Next(0,1000000));
        }
        Console.WriteLine("Feito");

       List<Double> lista = new List<Double>();
        lista.AddRange(hash);

        Console.WriteLine("Feito passagem do hash para arraylist");

        lista.Sort();

        Console.WriteLine("Feito ordenacao");