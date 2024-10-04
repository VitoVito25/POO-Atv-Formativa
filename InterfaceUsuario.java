import java.util.Scanner;

/**
 * Classe para funções de interface do usuario
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para limpar o console
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpar o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o console no Unix/Linux/MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console.");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para solicitar o valor total do imovel
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public double solicitaValorImovel(){

        System.out.println("Insira o valor total do Imovel: ");
        double valorImovel = this.scanner.nextDouble();
        this.scanner.nextLine();

        return valorImovel;
    }

    /**
     * Metodo para solicitar o valor total do imovel
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public int solicitaPrazoFinanciamento(){

        System.out.println("Insira o prazo do financiamento (Em anos): ");
        int prazoFinanciamento = this.scanner.nextInt();
        this.scanner.nextLine();

        return prazoFinanciamento;
    }
}
