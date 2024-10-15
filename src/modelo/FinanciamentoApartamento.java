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
     * @version 1.3
     */
    public double calcularPagamentoMensal() {

        /* 
        this.jurosDecimalMensal()
        this.calcularPrazoMeses()
        double valorImovel = this.getValorImovel();  
        */

        double taxaJurosMensal = this.jurosDecimalMensal();
        double prazoFinanciamentoMeses = this.calcularPrazoMeses();

        double pagamentoMensal = (this.getValorImovel() * taxaJurosMensal * Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses)) /
                                 (Math.pow(1 + taxaJurosMensal, prazoFinanciamentoMeses) - 1);

        return pagamentoMensal;
    }

    /**
     * Metodo para calcular o valor total conforme calculo de pagamento mensal com o sistema PRICE
     * @return Retorna o valor total que dever ser pago do imovel
     * 
     * @author Victor Renaud
     * @version 1.1
     */
    public double calcularTotalPagamento() {
        return (this.calcularPagamentoMensal() * this.calcularPrazoMeses());
    }
}
