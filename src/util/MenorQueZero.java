package src.util;

public class MenorQueZero extends Exception {
    public MenorQueZero(String msg){
        super(msg);
    }

    /**
     * Método para verificar se o numero é menor que zero
     * 
     * @return True quando é menor que zero ou False quando é igual ou maior.
     * @author Victor Renaud
     * @version 1.1
     */
    public boolean verificarMenorQueZero(double numero) {
        if(numero < 0) {
            return true;
        } else {
            return false;
        }
    }
}