package src.modelo;
/**
 * Classe de financiamento especifico para Apartamentos
 * 
 * @author Victor Renaud
 * @version 1.0
 */

public class FinanciamentoApartamento extends Financiamento{
    
    private int vagasGaragem;
    private int numeroAndar;

    // Construtor
    public FinanciamentoApartamento(double valorImovel, double prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    // Getters
    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    // Setters
    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }

    /**
     * Metodo para calcular o pagamento mensal com o sistema de amortização PRICE
     * @return Retorna o valor do pagamento mensal do financiamento
     * 
     * @author Victor Renaud
     * @version 1.3
     * @Overwrite
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
     * @Overwrite
     */
    public double calcularTotalPagamento() {
        return (this.calcularPagamentoMensal() * this.calcularPrazoMeses());
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
        System.out.println("#---- Detalhes do Financiamento Apartamento ----#");
        System.out.printf("Andar: %d \n", this.getNumeroAndar());
        System.out.printf("Vagas na garagem: %d\n", this.getVagasGaragem());
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.getValorImovel());
        System.out.printf("Prazo do Financiamento: %.1f anos\n", this.getPrazoFinanciamento());
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", this.getTaxaJurosAnual());
        System.out.printf("Valor do Pagamento Mensal: R$ %.2f\n", this.calcularPagamentoMensal());
        System.out.printf("Valor Total a ser Pago: R$ %.2f\n", this.calcularTotalPagamento());
        System.out.println("#----------------------------------#");
    }
    
}
