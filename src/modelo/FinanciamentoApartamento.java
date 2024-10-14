package src.modelo;
/**
 * Classe de financiamento especifico para Apartamentos
 * 
 * @author Victor Renaud
 * @version 1.0
 */

public class FinanciamentoApartamento extends Financiamento{
    
    // Construtor
    public FinanciamentoApartamento(double valorImovel, double prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    /**
     * Metodo para calcular o pagamento mensal com o sistema de amortização PRICE
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularPagamentoMensal() {
        double prazoFinanciamentoMeses = this.calcularPrazoMeses();
        double taxaJurosMensal = this.jurosDecimalMensal();

        double fatorPotencia = Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses);
        double valorPagamentoMensal = this.valorImovel * (taxaJurosMensal * fatorPotencia) / (fatorPotencia - 1);

        return valorPagamentoMensal;
    }
}
