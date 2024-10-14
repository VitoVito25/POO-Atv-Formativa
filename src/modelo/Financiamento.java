package src.modelo;

/**
 * Classe de financiamento
 * 
 * @author Victor Renaud
 * @version 1.1
 */
public class Financiamento {

    protected double valorImovel;
    protected double prazoFinanciamento; // Em anos
    protected double taxaJurosAnual;
    
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
        double prazoFinanciamentoMeses = this.calcularPrazoMeses();
        double taxaJurosMensal = this.calcularTaxaJurosMensal();
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
        double prazoFinanciamentoMeses = this.calcularPrazoMeses();
        double valorTotalPagamento = prazoFinanciamentoMeses * valorPagamentoMensal;

        return valorTotalPagamento;
    }

    /**
     * Metodo para calcular a taxa de juros Mensal
     * @return Retorna a taxa de juros em meses
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularTaxaJurosMensal() {
        double taxaJurosMensal = this.taxaJurosAnual / 12;

        return taxaJurosMensal;
    }

    /**
     * Metodo para calcular o prazo do financiamento em meses
     * @return Retorna o numero de meses até o final do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularPrazoMeses() {
        double prazoMeses = this.prazoFinanciamento * 12;

        return prazoMeses;
    }

    
}
