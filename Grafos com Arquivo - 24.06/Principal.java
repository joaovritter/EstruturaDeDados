package arquivoGrafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Principal {
    public static void main(String args[]) {
    	Scanner teclado = new Scanner (System.in);
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<String[]> arestas = new ArrayList<>(); //arestas é a ligacao entre cidades
        File arquivo = new File("cidades.txt"); //new file vai criar automatico o arquivo com o nome

        if (!arquivo.exists()) {
            try {
                FileWriter escritor = new FileWriter(arquivo);
                escritor.write("Sao Pedro@Santa Maria\n");
                escritor.write("Santa Maria@Agudo\n");
                escritor.write("Agudo@Santa Cruz\n");
                escritor.write("Santa Cruz@Porto Alegre\n");
                escritor.write("Porto Alegre@Lajeado\n");
                escritor.write("Lajeado@Soledade\n");
                escritor.write("Soledade@Cruz Alta\n");
                escritor.write("Cruz Alta@Julio de Castilhos\n");
                escritor.write("Julio de Castilhos@Itaara\n");
                escritor.write("Itaara@Sao Martinho\n");
                escritor.write("Itaara@Santa Maria\n");
                escritor.close();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
                return;
            }
        }

        try {
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) { //enquanto tiver proxima linha vai lendo
                String linha = scanner.nextLine();
                String[] partes = linha.split("@"); //separa as partes por @
                if (partes.length == 2) { //se tiver 2 partes, separa
                    String origem = partes[0].trim(); //trim para separar
                    String destino = partes[1].trim();

                    if (!cidades.contains(origem)) {
                        cidades.add(origem); //adiciona origem
                    }
                    if (!cidades.contains(destino)) {
                        cidades.add(destino); //adiciona destino
                    }
                    arestas.add(partes); //adiciona as partes
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("O arquivo não pôde ser lido: " + e.getMessage());
            return;
        }

        cidades.sort(null); //ordena
        Grafo grafo_rs = new Grafo(cidades);

        for (String[] aresta : arestas) { //percorre e insere ligacao entre cidades
            grafo_rs.inserirArestaSimetrica(aresta[0], aresta[1]);
        }

        grafo_rs.show(); 
        
        System.out.println("Cidade para pesquisar grau: ");
        String cidade = teclado.nextLine();
        System.out.println("Grau da cidade de " + cidade + ": " + grafo_rs.mostrarGrau(cidade));
    }
}