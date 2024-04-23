package Atividade;

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
			System.out.println("Nenhum atleta cadastrado!");
		}
}
	
	public static void listarPontuacao (ArrayList<Atleta> lista) {
		if (!lista.isEmpty()) {
			lista.sort((a2, a1)->((String)a2.getPontuacao()).compareTo(a1.getPontuacao()));
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
	
	
	public static void procurarNome (HashSet<Atleta> hashAtleta, String procuraNome, Atleta jogador) {
		if (jogador.getNome().equals(procuraNome)) {
			System.out.println(procuraNome +" Encontrado! ");
		}
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		int op;
		int opInterna;
		HashSet<Atleta> hashAtleta = new HashSet<Atleta>();
		ArrayList<Atleta> lista = new ArrayList<Atleta>();
		Atleta jogador = new Atleta();
		String nome, apelido, fone, dataNascimento, pontuacao;
		String procuraNome;
		do {
			System.out.println("Digite uma opcao de acordo com o menu: ");
			System.out.println("1- Listar Atleta (Nome ou pontuacao)");
			System.out.println("2- Cadastrar Atleta");
			System.out.println("3- Procurar Atleta (nome ou apelido)");
			System.out.println("4- Remover atleta (nome ou apelido)");
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
				System.out.println("Quer ver por 1- Nome ou 2- Apelido? ");
				opInterna = teclado.nextInt();
				teclado.nextLine();
				
				if (opInterna==1) {
					System.out.println("Digite o nome a ser procurado: ");
					procuraNome = teclado.nextLine();
				}
				
				if (opInterna==1) {
					System.out.println("Digite o nome a ser procurado: ");
					procuraNome = teclado.nextLine();
				}
				
				break;
				
			case 4:
				System.out.println("Encerrando programa...");		
				break;
				
			default: 
				System.out.println("Tecla invalida, Digite novamente!");
			}
			
		}while (true);
	}
	}


