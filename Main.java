import java.util.InputMismatchException;

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

        double valorImovel = 0;
        int prazoFinanciamento = 0;
        double taxaJuros = 0;

        boolean inputValido = false;

        // Validação para valor do imóvel
        while (!inputValido) {
            try {
                valorImovel = interfaceUsuario.solicitaValorImovel();
                inputValido = true; // Saí do laço quando o valor for válido
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número válido para o valor do imóvel.");
                interfaceUsuario.limparEntrada(); // Método para limpar o buffer do scanner, por exemplo
            }
        }

        inputValido = false;
        while (!inputValido) {
            try {
                prazoFinanciamento = interfaceUsuario.solicitaPrazoFinanciamento();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Prazo inválido. Por favor, insira um número inteiro para o prazo.");
                interfaceUsuario.limparEntrada(); // Método para limpar o buffer do scanner
            }
        }

        inputValido = false;

        // Validação para taxa de juros
        while (!inputValido) {
            try {
                taxaJuros = interfaceUsuario.solicitaTaxajuros();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Taxa de juros inválida. Por favor, insira um número válido.");
                interfaceUsuario.limparEntrada(); // Método para limpar o buffer do scanner
            }
        }

        Financiamento
        
    }
    
}
