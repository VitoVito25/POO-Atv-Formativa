import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe de financiamento
 * 
 * @author Victor Renaud
 * @version 1.0
 */
class Financiamento {

    private double valorImovel;
    private double prazoFinanciamento; // Em anos
    private double taxaJurosAnual;
    
    // Construtor
    public Financiamento(double valorImovel, double prazoFinanciamento, double taxaJurosAnual) {
        this.setValorImovel(valorImovel);
        this.setPrazoFinanciamento(prazoFinanciamento);
        this.setTaxaJurosAnual(taxaJurosAnual);
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public double getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Setters
    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setPrazoFinanciamento(double prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    /**
     * Metodo para calcular o pagamento mensal
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularPagamentoMensal() {
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        double valorPagamentoMensal = this.valorImovel / prazoFinanciamentoMeses * (1 + taxaJurosMensal);

        return valorPagamentoMensal;
    }

    /**
     * Metodo para calcular o valor total que deve ser pago do imovel
     * @return Retorna o valor total que dever ser pago do imovel
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularTotalPagamento() {
        double valorPagamentoMensal = calcularPagamentoMensal();
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double valorTotalPagamento = prazoFinanciamentoMeses * valorPagamentoMensal;

        return valorTotalPagamento;
    }

    /**
     * Metodo imprimir os detalhes do financiamento na tela
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public void imprimirDetalhesFinanciamento() {
        System.out.println("#---- Detalhes do Financiamento ----#");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %.1f anos\n", getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", getTaxaJurosAnual());
        System.out.printf("Valor do Pagamento Mensal: R$ %.2f\n", calcularPagamentoMensal());
        System.out.printf("Valor Total a ser Pago: R$ %.2f\n", calcularTotalPagamento());
        System.out.println("#----------------------------------#");
    }
}

/**
 * Classe para funções de interface do usuario
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para limpar o console
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void clearConsole() {
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


}

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

        double valorImovel = interfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitaTaxajuros();

        Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        novoFinanciamento.imprimirDetalhesFinanciamento();
        
    }
    
}
