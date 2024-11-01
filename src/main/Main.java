package src.main;
import java.util.ArrayList;
import java.util.Scanner;

import src.modelo.*;
import src.util.InterfaceUsuario;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe principal do programa
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class Main {
    /**
     * Função principal do programa
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>(); // Lista de financiamentos
        interfaceUsuario.clearConsole();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nMenu de Financiamento:");
            System.out.println("1 - Financiamento de Casa");
            System.out.println("2 - Financiamento de Apartamento");
            System.out.println("3 - Financiamento de Terreno");
            System.out.print("Escolha uma opção (1-3): \n");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listaFinanciamento.add(interfaceUsuario.solicitaDadosCasa());
                    break;
                case 2:
                    listaFinanciamento.add(interfaceUsuario.solicitaDadosApartamento());
                    break;
                case 3:
                    listaFinanciamento.add(interfaceUsuario.solicitaDadosTerreno());
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao < 1 || opcao > 3);

        // Adicionando os financimentos direto no código
        listaFinanciamento.add(new FinanciamentoCasa(330000, 15, 10, 40, 80));
        listaFinanciamento.add(new FinanciamentoCasa(500000, 10, 10, 70, 100));
        listaFinanciamento.add(new FinanciamentoApartamento(500000, 10, 10, 2, 5));
        listaFinanciamento.add(new FinanciamentoApartamento(320000, 10, 10, 3, 10));
        listaFinanciamento.add(new FinanciamentoTerreno(500000, 10, 10, "Urbano"));

        interfaceUsuario.imprimirListaFinanciamento(listaFinanciamento);

        scanner.nextLine();
        interfaceUsuario.clearConsole();

        // Escrita e leitura em arquivo TXT
        FileWriter writer = null; // Para escrever no arquivo

        try {
            writer = new FileWriter("financiamentos.txt"); // Para escrever no arquivo

            for(Financiamento financiamento : listaFinanciamento) {
                writer.write(financiamento.toString() + "\n\n");
            }
            String rodape = interfaceUsuario.toStringTotaisFinanciamentos(listaFinanciamento);
            writer.write(rodape);
            
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        interfaceUsuario.clearConsole();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("financiamentos.txt"));
            String linha;
            StringBuilder conteudoArquivo = new StringBuilder();
        
            while ((linha = reader.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n");
            }
        
            System.out.println(conteudoArquivo.toString()); // Exibe o conteúdo do arquivo
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }     
        scanner.nextLine();
        interfaceUsuario.clearConsole();

        // Serialização
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("financiamentosSerializados.fin"))){
            out.writeObject(listaFinanciamento);
        } catch (IOException  e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
        }

        // Desserialização
        ArrayList<Financiamento> listaFinanciamentoDesserializada = null;
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("financiamentosSerializados.fin"))) {
            listaFinanciamentoDesserializada = (ArrayList<Financiamento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
        }

        interfaceUsuario.imprimirListaFinanciamento(listaFinanciamentoDesserializada);
        scanner.nextLine();
        interfaceUsuario.clearConsole();

        scanner.close();
    }
}

