package src.modelo;

/**
 * Classe de financiamento
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class Financiamento {

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