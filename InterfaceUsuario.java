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

    public double solicitaValorImovel(){

        System.out.println("Insira o valor total do Imovel: ");
        double valorImovel = this.scanner.nextDouble();

        return valorImovel;
    }
}
