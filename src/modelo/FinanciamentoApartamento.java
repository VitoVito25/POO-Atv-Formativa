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

}
