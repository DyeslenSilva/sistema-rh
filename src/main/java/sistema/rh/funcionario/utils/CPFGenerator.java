package sistema.rh.funcionario.utils;

import java.util.Random;

public class CPFGenerator {

    // Gera um CPF válido
    public static String generateCPF() {
        Random random = new Random();
        
        // Gera os 9 primeiros dígitos
        int[] cpf = new int[11];
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        // Calcula o primeiro dígito verificador
        cpf[9] = calculateCheckDigit(cpf, 10);
        
        // Calcula o segundo dígito verificador
        cpf[10] = calculateCheckDigit(cpf, 11);

        // Converte o CPF para string formatada
        return String.format("%03d%03d%03d%02d", cpf[0] * 100 + cpf[1] * 10 + cpf[2],
                                          cpf[3] * 100 + cpf[4] * 10 + cpf[5],
                                          cpf[6] * 100 + cpf[7] * 10 + cpf[8],
                                          cpf[9] * 10 + cpf[10]);
    }

    // Calcula o dígito verificador com base nos 9 primeiros dígitos
    private static int calculateCheckDigit(int[] cpf, int length) {
        int sum = 0;
        int weight = length;

        for (int i = 0; i < length - 1; i++) {
            sum += cpf[i] * weight--;
        }

        int remainder = sum * 10 % 11;
        return remainder == 10 ? 0 : remainder;
    }

    public static void main(String[] args) {
        // Testa a geração de CPF
        String cpf = generateCPF();
        System.out.println("CPF gerado: " + cpf);
    }
}
