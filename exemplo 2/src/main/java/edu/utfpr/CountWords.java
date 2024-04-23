package edu.utfpr;


public class CountWords {
    public int count(String str) {
        int words = 0;
        char last = ' ';

        // Itera através de cada caractere na string
        for (int i = 0; i < str.length(); i++) {

            // Se o caractere atual não for uma letra e o caractere anterior foi "s" ou "r", temos uma palavra!
            if (!Character.isLetter(str.charAt(i)) && (last == 's' || last == 'r')) {
                words++; 
            }

            //Armazena o caracter atual como o "último"
            last = str.charAt(i);
        }

        // Conta mais uma palavra se a string terminar em "r" ou "s"
        if (last == 'r' || last == 's') {
            words++;
        }
        return words;
    }
}
