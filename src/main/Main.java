package src.main;
import java.util.ArrayList;
import src.modelo.Financiamento;
import src.modelo.FinanciamentoCasa;
import src.modelo.FinanciamentoApartamento;
import src.modelo.FinanciamentoTerreno;
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
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>(); // Lista de financiamentos

        double valorImovel = interfaceUsuario.solicitaValorImovel();
        int prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitaTaxajuros();
        interfaceUsuario.clearConsole();

        for(int cont = 1; cont <= 5; cont++ ) {
            if(cont <=2) {
                listaFinanciamento.add(new Financiamento(valorImovel, prazoFinanciamento, taxaJuros));
            }else if(cont <= 4) {
                listaFinanciamento.add(new FinanciamentoCasa(valorImovel, prazoFinanciamento, taxaJuros));
                
            }else{
                listaFinanciamento.add(new FinanciamentoTerreno(valorImovel, prazoFinanciamento, taxaJuros));
            }
        }

        interfaceUsuario.clearConsole();
        interfaceUsuario.imprimirDetalhesFinanciamento(listaFinanciamento.get(3));
        interfaceUsuario.imprimirListaFinanciamento(listaFinanciamento);
        
    }
    
}
