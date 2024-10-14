package src.modelo;
/**
 * Classe de financiamento especifico para Casas
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class FinanciamentoCasa extends Financiamento{
    
    // Construtor
    public FinanciamentoCasa(double valorImovel, double prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    /**
     * Metodo para calcular o pagamento mensal com o adicional do seguro exclusivo para casa
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularPagamentoMensal() {
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        double valorPagamentoMensal = (this.valorImovel / prazoFinanciamentoMeses * (1 + taxaJurosMensal)) + 80;

        return valorPagamentoMensal;
    }

}
