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

}
