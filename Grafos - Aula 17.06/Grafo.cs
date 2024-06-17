using System;
using System.Collections.Generic;

public class Grafo
{
    public int[,] matrizAdjacencia;
    public List<string> vertices;
    public int qtdVertices;
    public int qtdArestas;

    public Grafo(List<string> vertices)
    {
        this.vertices = new List<string>();
        this.vertices.AddRange(vertices);
        this.qtdVertices = vertices.Count;
        this.qtdArestas = 0;
        this.matrizAdjacencia = new int[this.qtdVertices, this.qtdVertices];
        for (int i = 0; i < this.qtdVertices; i++)
        {
            for (int j = 0; j < this.qtdVertices; j++)
            {
                this.matrizAdjacencia[i, j] = 0;
            }
        }
    }

    public void InserirArestaSimetrica(string origem, string destino)
    {
        int indiceOrigem = this.vertices.IndexOf(origem);
        int indiceDestino = this.vertices.IndexOf(destino);
        if (origem.Equals(destino, StringComparison.OrdinalIgnoreCase) || indiceOrigem == -1 || indiceDestino == -1)
        {
            return;
        }

        if (this.matrizAdjacencia[indiceOrigem, indiceDestino] == 0)
        {
            this.matrizAdjacencia[indiceOrigem, indiceDestino] = 1;
            this.qtdArestas++;
        }
        if (this.matrizAdjacencia[indiceDestino, indiceOrigem] == 0)
        {
            this.matrizAdjacencia[indiceDestino, indiceOrigem] = 1;
            this.qtdArestas++;
        }
    }

    public void Show()
    {
        for (int i = 0; i < this.qtdVertices; i++)
        {
            Console.Write(this.vertices[i] + "\t\t\t");
            for (int j = 0; j < this.qtdVertices; j++)
            {
                if (this.matrizAdjacencia[i, j] != 0)
                {
                    Console.Write(this.vertices[j] + "\t\t\t");
                }
            }
            Console.WriteLine();
        }
    }

    public int MostrarGrau(string cidade)
    {
        int indice = this.vertices.IndexOf(cidade);
        if (indice == -1) return -27;
        int qtd = 0;
        for (int i = 0; i < this.qtdVertices; i++)
        {
            if (this.matrizAdjacencia[indice, i] != 0)
            {
                qtd++;
            }
            if (this.matrizAdjacencia[i, indice] != 0)
            {
                qtd++;
            }
        }
        return qtd;
    }
}

public class Principal
{
    public static void Main(string[] args)
    {
        List<string> cidades = new List<string>
        {
            "Sao Pedro", "Santa Maria", "Agudo", "Santa Cruz", "Itaara", "Sao Martinho",
            "Julio de Castilhos", "Cruz Alta", "Soledade", "Lajeado", "Porto Alegre"
        };

        cidades.Sort();

        Grafo grafo_rs = new Grafo(cidades);
        grafo_rs.InserirArestaSimetrica("Sao Pedro", "Santa Maria");
        grafo_rs.InserirArestaSimetrica("Santa Maria", "Agudo");
        grafo_rs.InserirArestaSimetrica("Agudo", "Santa Cruz");
        grafo_rs.InserirArestaSimetrica("Santa Cruz", "Porto Alegre");
        grafo_rs.InserirArestaSimetrica("Porto Alegre", "Lajeado");
        grafo_rs.InserirArestaSimetrica("Lajeado", "Soledade");
        grafo_rs.InserirArestaSimetrica("Soledade", "Cruz Alta");
        grafo_rs.InserirArestaSimetrica("Cruz Alta", "Julio de Castilhos");
        grafo_rs.InserirArestaSimetrica("Julio de Castilhos", "Itaara");
        grafo_rs.InserirArestaSimetrica("Itaara", "Sao Martinho");
        grafo_rs.InserirArestaSimetrica("Itaara", "Santa Maria");

        grafo_rs.Show();

        string cidade = "Itaara";
        Console.WriteLine("Grau da cidade de " + cidade + ": " + grafo_rs.MostrarGrau(cidade));
    }
}
