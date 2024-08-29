package edu.utfpr;


import java.util.List;
import java.util.Arrays;



public class Main {    
    public static void main(String[] args) {
        
        final Add add = new Add();
        
        List<Integer> left = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        List<Integer> right = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 9);

        int maxSize = Math.max(left.size(), right.size());
        List<Integer> result = add.add(left, right);
        int expectedSumLast = (left.get(0) + right.get(0)) % 10;
        int expectedSumFirst = 0;

        if (left.size() == maxSize){
            expectedSumFirst += left.get(maxSize - 1);
        }
        if (right.size() == maxSize){
            expectedSumFirst += right.get(maxSize - 1);
        }
        if (left.size() == maxSize && right.size() == maxSize)
            maxSize++;

        if (Math.abs(left.size() - right.size()) == 1)
        expectedSumFirst++;

        if (expectedSumFirst >= 10)
            expectedSumFirst /= 10;




        System.out.println("Resultado: " + result);
        System.out.println("resultado tamanho: " + result.size());
        System.out.println("resultado tamanho esperado: " + (maxSize));
        System.out.println("resultado last: " + result.get(result.size() - 1));
        System.out.println("resultado last esperado: " + expectedSumLast);
        System.out.println("resultado first: " + result.get(0));
        System.out.println("resultado first esperado: " + expectedSumFirst);
    }
}
