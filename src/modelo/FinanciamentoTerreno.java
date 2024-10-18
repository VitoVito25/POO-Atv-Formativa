package src.modelo;
/**
 * Classe de financiamento especifico de Terreno
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class FinanciamentoTerreno extends Financiamento{

    private String tipoZona;

    // Construtor
    public FinanciamentoTerreno(double valorImovel, double prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    /**
     * Metodo para calcular o pagamento total com o adicional de 2% para risco de inadimplência 
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     * @Overwrite
     */
    public double calcularTotalPagamento() {
        return (super.calcularTotalPagamento() * 1.02);
    }
}
