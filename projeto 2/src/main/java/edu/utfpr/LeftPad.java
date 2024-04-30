package edu.utfpr;


public class LeftPad {
    public static String pad(final String str, final int size, String padStr) {

        // Verifica se a string é nula ou se ja possui o tamanho desejado
        if (str == null || str.length() >= size) {
            return str;
        }


        // Verifica se o tamanho do padStr é 0
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }


        // Cria uma string com o tamanho desejado
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size - str.length(); i+=padStr.length()) {
            sb.append(padStr);
        }


        // Adiciona a string desejada no final
        sb.append(str);


        return sb.toString();
    }
}
