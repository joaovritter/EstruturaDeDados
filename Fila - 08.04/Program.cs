using System;
using System.Collections.Generic;
using Fila;

public class Principal
{

    static void chamar(Queue<Cliente> fila, int quantidadeAtendimento)
    {
        Cliente obj = fila.Dequeue();
        Console.WriteLine("Chamando ficha ..." + obj.FichaAtendimento);
        throw new Exception("Ocorreu um erro no método MetodoQuePodeLancarExcecao.");

        quantidadeAtendimento++;     
    }

    static void menu(Queue<Cliente> filaNormal, Queue<Cliente> filaPrioritaria)
    {
        int quantidadeAtendimento = 0;
        int contadorNormal = 0;
        int contadorPrioritario = 1000;


        string textoMenu = string.Empty;

        textoMenu += "1 - Normal\n";
        textoMenu += "2 - Prioritário\n";
        textoMenu += "3 - Chamar\n";
        textoMenu += "4 - Finalizar\n";
        textoMenu += "Opção: ";

        string op;
        string fone, nome;
        do
        {
            Console.Write(textoMenu);
            op = Console.ReadLine();

            switch (op)
            {
                case "1":
                    contadorNormal++;
                    Console.Write("Nome: ");
                    nome = Console.ReadLine().ToUpper();
                    Console.Write("Fone: ");
                    fone = Console.ReadLine();
                    filaNormal.Enqueue(new Cliente(fone, nome, contadorNormal));
                    Console.WriteLine("Imprimindo ficha..." + contadorNormal);
                    break;
                case "2":
                    contadorPrioritario++;
                    nome = Console.ReadLine().ToUpper();
                    fone = Console.ReadLine();
                    filaPrioritaria.Enqueue(new Cliente(fone, nome, contadorPrioritario));
                    Console.WriteLine("Imprimindo ficha..." + contadorPrioritario);
                    break;
                case "3":
                    if (quantidadeAtendimento % 3 == 0)
                    {
                        //chamar ficha prioritaria
                        try
                        {
                            chamar(filaPrioritaria, quantidadeAtendimento);
                        }
                        catch (Exception e)
                        {
                            try
                            {
                                chamar(filaNormal, quantidadeAtendimento);
                            }
                            catch (Exception e2)
                            {

                            }
                        }
                    }
                    else
                    {
                        //chamar ficha normal
                        try
                        {
                            chamar(filaNormal, quantidadeAtendimento);
                        }
                        catch (Exception e)
                        {
                            try
                            {
                                chamar(filaPrioritaria, quantidadeAtendimento);
                            }
                            catch (Exception e3)
                            {

                            }
                        }
                    }
                    break;
                case "4":

                    break;

                default:
                    Console.WriteLine("Opção inválida");
                    break;
            }
        } while (!op.Equals("4"));


    }

    static void Main(string[] args)
    {
        Queue<Cliente> filaNormal = new Queue<Cliente>();
        Queue<Cliente> filaPrioritaria = new Queue<Cliente>();

        menu(filaNormal, filaPrioritaria);

        
    }
}