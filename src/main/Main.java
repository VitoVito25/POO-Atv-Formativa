package src.main;
import java.util.ArrayList;
import java.util.Scanner;

import src.modelo.Financiamento;
import src.util.InterfaceUsuario;

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
            System.out.println("4 - Imprimir lista de financiamentos");
            System.out.println("9 - Sair do sistema");
            System.out.print("Escolha uma opção (1-4, 9 para sair): ");
            
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
                case 4:
                    interfaceUsuario.imprimirListaFinanciamento(listaFinanciamento);;
                    break;
                case 9:
                    System.out.println("Saindo do sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
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
    
