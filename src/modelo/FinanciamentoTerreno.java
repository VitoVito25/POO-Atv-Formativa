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
        return (super.calcularPagamentoMensal() * 1.02);
    }
}
