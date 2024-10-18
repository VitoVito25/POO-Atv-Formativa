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

    // Getter
    public String getTipoZona() {
        return tipoZona;
    }

    // Setter
    public void setTipoZona(String tipoZona) {
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

    /**
     * Metodo imprimir os detalhes do financiamento na tela
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     * @Overwrite
     */
    public void imprimirDetalhesFinanciamento() {
        System.out.println("#---- Detalhes do Financiamento Terreno ----#");
        System.out.printf("Tipo da zona do terreno: %.2f m²\n", this.getTipoZona());
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.getValorImovel());
        System.out.printf("Prazo do Financiamento: %.1f anos\n", this.getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", this.getTaxaJurosAnual());
        System.out.printf("Valor do Pagamento Mensal: R$ %.2f\n", this.calcularPagamentoMensal());
        System.out.printf("Valor Total a ser Pago: R$ %.2f\n", this.calcularTotalPagamento());
        System.out.println("#----------------------------------#");
    }
}
