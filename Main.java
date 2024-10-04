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

        double valorImovel = interfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitaTaxajuros();

        Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        
        
    }
    
}
