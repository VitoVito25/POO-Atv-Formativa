package src.modelo;

import src.util.DescontoMaiorDoQueJurosException;

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

    public double getAreaConstruida() {
        return areaConstruida;
    }
    
    // Setters
    public void setTamanhoTerreno(double tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }
    
    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    /**
     * Metodo para calcular o valor do desconto.
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double calcularMensalidade() {
        double taxaJurosMensal = taxaJurosAnual / 100 / 12;
        return (valorImovel / (prazoFinanciamento * 12)) * (1 + taxaJurosMensal);
    }

    /**
     * Metodo para aplicar o desconto.
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double mensalidade = calcularMensalidade();
        double jurosMensal = (valorImovel * (taxaJurosAnual / 100)) / 12;

        if (desconto > jurosMensal) { // Verifica se o desconto é maior do que o valor dos juros mensais.
            throw new DescontoMaiorDoQueJurosException(
                    "O valor do desconto não pode ser maior do que o valor dos juros mensais.");
        }

        return mensalidade - desconto;
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

    /**
     * Método que retorna os detalhes do financiamento em uma String
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public String toString() {
        StringBuilder detalhes = new StringBuilder();

        detalhes.append("#---- Detalhes do Financiamento Casa ----#\n");
        detalhes.append(String.format("Tamanho do terreno: %.2f m²\n", this.getTamanhoTerreno()));
        detalhes.append(String.format("Área construída: %.2f m²\n", this.getAreaConstruida()));
        detalhes.append(String.format("Valor do Imóvel: R$ %.2f\n", this.getValorImovel()));
        detalhes.append(String.format("Prazo do Financiamento: %.1f anos\n", this.getPrazoFinanciamento()));
        detalhes.append(String.format("Taxa de Juros Anual: %.2f%%\n", this.getTaxaJurosAnual()));
        detalhes.append(String.format("Valor do Pagamento Mensal: R$ %.2f\n", this.calcularPagamentoMensal()));
        detalhes.append(String.format("Valor Total a ser Pago: R$ %.2f\n", this.calcularTotalPagamento()));
        detalhes.append("#----------------------------------#");

        return detalhes.toString();
}
}
