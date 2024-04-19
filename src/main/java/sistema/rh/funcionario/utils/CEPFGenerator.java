package sistema.rh.funcionario.utils;

import java.util.Random;

public class CEPFGenerator {

    // Crie um objeto Random para gerar números aleatórios
    private static Random random = new Random();

    // Método para gerar um dígito aleatório (número de 0 a 9)
    private static int gerarDigitoAleatorio() {
        return random.nextInt(10); // Gera um número de 0 a 9
    }

    // Método para gerar uma sequência de 5 dígitos aleatórios
    public static int gerarCEPF() {
        StringBuilder sequencia = new StringBuilder();

        // Gera uma sequência de 5 dígitos aleatórios
        for (int i = 0; i < 5; i++) {
            int digitoAleatorio = gerarDigitoAleatorio();
            sequencia.append(digitoAleatorio);
        }

        // Converte a sequência para um número inteiro e retorna
        return Integer.parseInt(sequencia.toString());
    }

    public static void main(String[] args) {
        // Gera uma sequência de 5 dígitos aleatórios
        int cepf = gerarCEPF();
        
        // Imprime a sequência gerada
        System.out.println("CEPF gerado: " + cepf);
    }
}
