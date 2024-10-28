package src.modelo;
/**
 * Classe de financiamento especifico para Casas
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class FinanciamentoCasa extends Financiamento{
    
    private double tamanhoTerreno;
    private double areaConstruida; 

    // Construtor
    public FinanciamentoCasa(double valorImovel, double prazoFinanciamento, double taxaJurosAnual, double tamanhoTerreno, double areaConstruida) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoTerreno = tamanhoTerreno;
        this.areaConstruida = areaConstruida;
    }

    // Getters
    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }
    
    public void setTamanhoTerreno(double tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }
    
    // Setters
    public double getAreaConstruida() {
        return areaConstruida;
    }
    
    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    /**
     * Metodo para calcular o total do valor do financiamento com o reajuste de R$80 a mais por parcela
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     * @Overwrite
     */
    public double calcularTotalPagamento() {
        return (super.calcularTotalPagamento() + this.calcularPrazoMeses() * 80);
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
        System.out.println("#---- Detalhes do Financiamento Casa ----#");
        System.out.printf("Tamanho do terreno: %.2f m²\n", this.getTamanhoTerreno());
        System.out.printf("Area construida: %.2f m²\n", this.getAreaConstruida());
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.getValorImovel());
        System.out.printf("Prazo do Financiamento: %.1f anos\n", this.getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", this.getTaxaJurosAnual());
        System.out.printf("Valor do Pagamento Mensal: R$ %.2f\n", this.calcularPagamentoMensal());
        System.out.printf("Valor Total a ser Pago: R$ %.2f\n", this.calcularTotalPagamento());
        System.out.println("#----------------------------------#");
    }

}
