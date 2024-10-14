package src.main;
import src.modelo.Financiamento;
import src.util.InterfaceUsuario;

/**
 * Classe principal do programa
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class Main {
    /**
     * Função principal do programa
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>();

        double valorImovel = interfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitaTaxajuros();

        Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        novoFinanciamento.imprimirDetalhesFinanciamento();
        
    }
    
}
