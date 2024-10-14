package src.main;
import java.util.ArrayList;
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
        ArrayList<Financiamento> listaFinanciamento = new ArrayList<>(); // Lista de financiamentos
        for(int cont = 1; cont <= 4; cont++ ) {
            interfaceUsuario.clearConsole();
            System.out.printf("Digite os dados do financiamento %d \n", cont);
            double valorImovel = interfaceUsuario.solicitaValorImovel();
            int prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
            double taxaJuros = interfaceUsuario.solicitaTaxajuros();

            listaFinanciamento.add(new Financiamento(valorImovel, prazoFinanciamento, taxaJuros));
        }

        interfaceUsuario.clearConsole();
        interfaceUsuario.imprimirListaFinanciamento(listaFinanciamento);
        
    }
    
}
