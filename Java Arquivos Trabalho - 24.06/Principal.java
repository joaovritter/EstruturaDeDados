package Avaliacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;


public class Principal {

	public static void listarNomes (ArrayList<Atleta> lista) {
		if (!lista.isEmpty()) {
		lista.sort((a1, a2)->((String)a1.getNome()).compareTo(a2.getNome()));
			for (Atleta item : lista){
				System.out.println(item);
			}
		}
		else {
			System.out.println("Nenhum atleta cadastrado");
		}
	}
	
	public static void listarPontuacao (ArrayList<Atleta> lista) {
		if (!lista.isEmpty()) {
			lista.sort((a2, a1)->((String)a1.getPontuacao()).compareTo(a2.getPontuacao()));
			for (Atleta pontos : lista){
				System.out.println(pontos);	
			}
		}
		else {
			System.out.println("Nenhum atleta cadastrado!");
		}
	}
	
	public static void cadastrar (HashSet<Atleta> hashAtleta, Atleta jogador , String nome, String apelido, String fone, String dataNascimento, String pontuacao) {
		System.out.println("CADASTRANDO ATLETA: ");
		jogador = new Atleta (nome, apelido, fone, dataNascimento, pontuacao);
		if (!hashAtleta.add(jogador)) {
			System.out.println("Atleta ja cadastrado");
		}
	
	}
	
	public static void procurarNome (HashSet<Atleta> hashAtleta, String nome) {
		    boolean encontrado = false;
		    for (Atleta jogador : hashAtleta) {
		        if (jogador.getNome().equals(nome)) {
		            encontrado = true;
		            System.out.println(nome + " encontrado!");
		            break; // Se encontrou, não precisa continuar procurando
		        }
		    }
		    if (!encontrado) {
		        System.out.println("Atleta não encontrado.");
		    }
		}

	
	public static void procurarApelido (HashSet<Atleta> hashAtleta, String Apelido) {
		 boolean encontrado = false;
		    for (Atleta jogador : hashAtleta) {
		        if (jogador.getApelido().equals(Apelido)) {
		            encontrado = true;
		            System.out.println(Apelido + " encontrado!");
		            break; // Se encontrou, não precisa continuar procurando
		        }
		    }
		    	if (!encontrado) {
		        System.out.println("Atleta não encontrado.");
		    }
		}
	
	public static void removerNome (HashSet<Atleta> hashAtleta, String nome) {
		boolean removido = false;
		for (Atleta jogador : hashAtleta) {
				if (jogador.getNome().equals(nome)) {
					hashAtleta.remove(jogador);
					removido = true;
					System.out.println("Atleta removido: "+jogador);
					break;
				}
				if (!removido) {
					System.out.println("Atleta não encontrado.");
				}
			}
		}
	
	public static void removerApelido (HashSet<Atleta> hashAtleta, String apelido) {
		boolean removido = false;
		for (Atleta jogador : hashAtleta) {
			if (jogador.getApelido().equals(apelido)) {
				hashAtleta.remove(jogador);
				removido = true;
				System.out.println("Atleta removido: "+jogador);
				break;
			}
			if (!removido) {
				System.out.println("Atleta nao encontrado!");
			}
		}
		
	}


	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		HashSet<Atleta> hashAtleta = new HashSet<Atleta>();
		ArrayList<Atleta> lista = new ArrayList<Atleta>();
		Atleta jogador = new Atleta();
		
		int op;
		int opInterna;
		String nome, apelido, fone, dataNascimento, pontuacao;
		String procuraNome, procuraApelido, removeNome, removeApelido;
		do {
			System.out.println("\nDigite uma opcao de acordo com o menu: \n");
			System.out.println("1- Listar Atleta (Nome ou pontuacao)");
			System.out.println("2- Cadastrar Atleta");
			System.out.println("3- Procurar Atleta (nome ou apelido)");
			System.out.println("4- Remover atleta (nome ou apelido)\n");
			op = teclado.nextInt();
			teclado.nextLine();
			
			switch (op) {
			case 1:
				System.out.println("Quer ver por 1- nome ou 2- pontuacao? ");
				opInterna = teclado.nextInt();
				teclado.nextLine();
				lista.clear();
				
				if (opInterna==1) {
					 lista.addAll(hashAtleta);
				     listarNomes(lista);
				}
				if(opInterna==2) {
					lista.addAll(hashAtleta);
					listarPontuacao(lista);
				}
			break;
				
			case 2:
				System.out.println("CADASTRANDO ATLETA: ");
				System.out.println("Digite o nome: ");
				nome = teclado.nextLine();
				System.out.println("Digite o apelido: ");
				apelido = teclado.nextLine();
				System.out.println("Digite o fone: ");
				fone = teclado.nextLine();
				System.out.println("Digite o Data de Nascimento: ");
				dataNascimento = teclado.nextLine();
				System.out.println("Digite a Pontuacao: ");
				pontuacao = teclado.nextLine();
				cadastrar (hashAtleta, jogador, nome, apelido, fone, dataNascimento,pontuacao);
			
				break;
				
				
			case 3:
				System.out.println("Quer procurar por 1- Nome ou 2- Apelido? ");
				opInterna = teclado.nextInt();
				teclado.nextLine();
				
				if (opInterna==1) {
					System.out.println("Digite o Nome a ser procurado: ");
					procuraNome = teclado.nextLine();
					procurarNome (hashAtleta, procuraNome);
				}
				
				if (opInterna==2) {
					System.out.println("Digite o Apelido a ser procurado: ");
					procuraApelido = teclado.nextLine();
					procurarApelido (hashAtleta, procuraApelido);
				}
				
				break;
				
			case 4:
				System.out.println("Quer remover por 1- Nome ou 2- Apelido? ");
				opInterna = teclado.nextInt();
				teclado.nextLine();
				
				if (opInterna==1) {
					System.out.println("Digite o Nome a ser removido: ");
					removeNome = teclado.nextLine();
					removerNome (hashAtleta, removeNome);
				}
				
				if (opInterna==2) {
					System.out.println("Digite o Apelido a ser removido: ");
					removeApelido = teclado.nextLine();
					removerApelido (hashAtleta, removeApelido);
				}
				break;
				
			default: 
				System.out.println("Tecla invalida, Digite novamente!");
			}
			
		}while (true);
	}
	}


