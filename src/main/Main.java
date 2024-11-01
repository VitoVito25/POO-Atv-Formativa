package src.main;
import java.util.ArrayList;
import java.util.Scanner;

import src.modelo.*;
import src.util.InterfaceUsuario;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

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
            System.out.print("Escolha uma opção (1-3): ");
            
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



        scanner.close();
    }
}



        /*do {
            
        } while (condition:var(boolean));
        for(int cont = 1; cont <= 5; cont++ ) {
            if(cont <=2) {
                listaFinanciamento.add(new FinanciamentoCasa(valorImovel, prazoFinanciamento, taxaJuros));
            }else if(cont <= 4) {
                listaFinanciamento.add(new FinanciamentoApartamento(valorImovel, prazoFinanciamento, taxaJuros));
            }else{
                listaFinanciamento.add(new FinanciamentoTerreno(valorImovel, prazoFinanciamento, taxaJuros));
            }

        }

        interfaceUsuario.imprimirListaFinanciamento(listaFinanciamento);
        */
    
