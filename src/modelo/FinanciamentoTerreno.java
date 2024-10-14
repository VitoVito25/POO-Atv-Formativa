package src.modelo;
/**
 * Classe de financiamento especifico de Terreno
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class FinanciamentoTerreno extends Financiamento{

    // Construtor
    public FinanciamentoTerreno(double valorImovel, double prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    /**
     * Metodo para calcular o pagamento mensal com o adicional de 2% para risco de inadimplência 
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularPagamentoMensal() {
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        double valorPagamentoMensal = (this.valorImovel / prazoFinanciamentoMeses * (1 + taxaJurosMensal)) + 80;
        valorPagamentoMensal += valorPagamentoMensal * 0.02;

        return valorPagamentoMensal;
    }
}
