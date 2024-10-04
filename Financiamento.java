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
    
    // Constructor
    public Financiamento(double valorImovel, double prazoFinanciamento, double taxaJurosAnual ) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
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
    public double totalPagamento() {
        double valorPagamentoMensal = calcularPagamentoMensal();
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double valorTotalPagamento = prazoFinanciamentoMeses * valorPagamentoMensal;

        return valorTotalPagamento;
    }
}