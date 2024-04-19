package sistema.rh.funcionario.utils;
import java.util.Random;

public class SorteioEstado {

    // Lista de siglas dos estados brasileiros
    private static final String[] ESTADOS = {
        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
        "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
        "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC",
        "SP", "SE", "TO"
    };

    public static void main(String[] args) {
    	String estado = sorteioEstado();
    	System.out.println(estado);
    }
    
    
    public static String sorteioEstado() {
        Random random = new Random();
        int indiceSorteado = random.nextInt(ESTADOS.length);
        String estadoSorteado = ESTADOS[indiceSorteado];
       return estadoSorteado;
    }
}
