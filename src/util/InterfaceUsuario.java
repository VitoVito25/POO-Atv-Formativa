package src.util;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import src.modelo.Financiamento;
/**
 * Classe para funções de interface do usuario
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para limpar o console
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpar o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o console no Unix/Linux/MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console.");
            e.printStackTrace();
        }
    }

    /**
     * Metodo limpar a entrada do Scanner
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public void limparEntrada() {
        scanner.nextLine(); // Limpa a linha do buffer
    }

    /**
     * Metodo para solicitar o valor total do imovel
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double solicitaValorImovel(){
        double valorImovel = 0;
        boolean entradaValida = false; // Variável de controle para validar a entrada

        while (!entradaValida) {
            try {
                System.out.println("Insira o valor total do Imovel: ");
                valorImovel = this.scanner.nextInt();
                this.limparEntrada();// Limpa o buffer
                if (valorImovel < 0) {
                    // Caso o valor seja negativo retorna a solicitação
                    System.out.println("O valor total do Imovel não pode ser negativo. Tente novamente.");
                } else {
                    entradaValida = true; // Marca a entrada como válida
                }
            } catch (InputMismatchException e) {
                // Em caso de erro, a solicitação é feita novamente
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                this.limparEntrada();// Limpa o buffer
            }
        }

        return valorImovel;
    }

    /**
     * Metodo para solicitar o valor total do imovel
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public int solicitaPrazoFinanciamento(){
        int prazoFinanciamento = 0;
        boolean entradaValida = false; // Variável de controle para validar a entrada

        while (!entradaValida) {
            try {
                System.out.println("Insira o prazo do financiamento (Em anos): ");
                prazoFinanciamento = this.scanner.nextInt();
                this.limparEntrada();// Limpa o buffer
                if (prazoFinanciamento < 0) {
                    // Caso o valor seja negativo retorna a solicitação
                    System.out.println("O prazo do financiamento não pode ser negativo. Tente novamente.");
                } else {
                    entradaValida = true; // Marca a entrada como válida
                }
            } catch (InputMismatchException e) {
                // Em caso de erro, a solicitação é feita novamente
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                this.limparEntrada();// Limpa o buffer
            }
        }

        return prazoFinanciamento;
    }

    /**
     * Metodo para solicitar a taxa de juros anual
     * 
     * 
     * @author Victor Renaud
     * @version 1.1
     */
    public double solicitaTaxajuros(){
        double taxaJurosAnual = 0;
        boolean entradaValida = false; // Variável de controle para validar a entrada

        while (!entradaValida) {
            try {
                System.out.println("Insira o valor da taxa de juros anual: ");
                taxaJurosAnual = this.scanner.nextDouble();
                this.limparEntrada();// Limpa o buffer
                if (taxaJurosAnual < 0) {
                    // Caso o valor seja negativo retorna a solicitação
                    System.out.println("A taxa de juros não pode ser negativa. Tente novamente.");
                } else {
                    entradaValida = true; // Marca a entrada como válida
                }
            } catch (InputMismatchException e) {
                // Em caso de erro, a solicitação é feita novamente
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                this.limparEntrada();// Limpa o buffer
            }
        }

        return taxaJurosAnual;

    }

    

    public void imprimirListaFinanciamento(ArrayList<Financiamento> listaFinanciamento) {
        int tamanhoLista = listaFinanciamento.size();
        double totalImoveis = 0, totalFinanciamento = 0;
        for(int cont = 1; cont <= tamanhoLista; cont++) {
            System.out.printf("Financiamento %d - Valor do Imovel: R$ %.2f - Valor do Financiamento: R$ %.2f \n", 
            cont, listaFinanciamento.get(cont - 1).getValorImovel(), listaFinanciamento.get(cont - 1).calcularTotalPagamento());
            totalImoveis += listaFinanciamento.get(cont - 1).getValorImovel();
            totalFinanciamento += listaFinanciamento.get(cont - 1).calcularTotalPagamento();
        }
        System.out.printf("Total de todos os imoveis: R$ %.2f - Total de todos os financiamentos R$ %,2f",
        totalImoveis, totalFinanciamento);
    }
}
