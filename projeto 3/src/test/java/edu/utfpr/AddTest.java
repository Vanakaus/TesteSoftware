package edu.utfpr;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.NotEmpty;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertThrows;




public class AddTest {

    private final Add add = new Add();



    // Testes com listas nulas ou vazias
    @Property
    boolean addNullLists(@ForAll List<@IntRange(min = 0, max = 9) Integer> list) {

        List<Integer> result1 = add.add(list, null);
        List<Integer> result2 = add.add(null, list);
        List<Integer> result3 = add.add(null, null);


        return result1 == null
        && result2 == null
        && result3 == null;
    }



    // Testes com listas vazias
    @Property
    boolean addEmptyListsReturnsEmptyList(@ForAll List<@IntRange(min = 0, max = 9) Integer> listRaw) {

        // Cria uma lista imutável vazia
        List<Integer> emptyList = Collections.emptyList();

        // Cria duas copias da lista original
        List<Integer> list1 = Arrays.asList(listRaw.toArray(new Integer[0]));
        List<Integer> list2 = Arrays.asList(listRaw.toArray(new Integer[0]));

        // Realiza os testes
        List<Integer> result1 = add.add(emptyList, emptyList);
        List<Integer> result2 = add.add(list1, emptyList);
        List<Integer> result3 = add.add(emptyList, list2);

        // Verifica se o resultado esta correto
        return result1.isEmpty()
        && result2.equals(listRaw)
        && result3.equals(listRaw);
    }



    // Testes com listas de um dígito (sem carry)
    @Property
    boolean addSingleDigitNoCarry(@ForAll @IntRange(min = 0, max = 4) int leftDigit,
                                  @ForAll @IntRange(min = 0, max = 4) int rightDigit) {
        List<Integer> left = Collections.singletonList(leftDigit);
        List<Integer> right = Collections.singletonList(rightDigit);
        List<Integer> result = add.add(left, right);


        return result.size() == 1 && result.get(0) == leftDigit + rightDigit;
    }



    // Testes com listas de um dígito (com carry)
    @Property
    boolean addSingleDigitWithCarry(@ForAll @IntRange(min = 5, max = 9) int leftDigit,
                                    @ForAll @IntRange(min = 5, max = 9) int rightDigit) {
        List<Integer> left = Collections.singletonList(leftDigit);
        List<Integer> right = Collections.singletonList(rightDigit);
        List<Integer> result = add.add(left, right);
        int sum = leftDigit + rightDigit;
        int expectedSum = sum % 10;
        int expectedCarry = sum / 10;

        if (expectedCarry == 0) {
            return result.size() == 1 && result.get(0) == expectedSum;
        } else {
            return result.size() == 2 && result.get(0) == expectedCarry && result.get(1) == expectedSum;
        }
    }



    // Teste com listas de n dígitos (sem carry)
    @Property
    boolean addMultipleDigitsNoCarry(@ForAll @NotEmpty List<@IntRange(min = 0, max = 4) Integer> left,
                                     @ForAll @NotEmpty List<@IntRange(min = 0, max = 4) Integer> right) {
        
        int maxSize = Math.max(left.size(), right.size());
        List<Integer> result = add.add(left, right);
        int expectedSumLast = left.get(0) + right.get(0);
        int expectedSumFirst = 0;

        if (left.size() == maxSize){
            expectedSumFirst += left.get(maxSize - 1);
        }
        if (right.size() == maxSize){
            expectedSumFirst += right.get(maxSize - 1);
        }

        return result.size() == maxSize && result.get(result.size() - 1) == expectedSumLast && result.get(0) == expectedSumFirst;
    }



    // Teste com listas de n dígitos (com carry)
    @Property
    boolean addMultipleDigitsWithCarry(@ForAll @NotEmpty List<@IntRange(min = 5, max = 9) Integer> left,
                                       @ForAll @NotEmpty List<@IntRange(min = 5, max = 9) Integer> right) {

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
        
        
        return result.size() == maxSize && result.get(result.size() - 1) == expectedSumLast && result.get(0) == expectedSumFirst;
    }



    // Teste de propriedade para exceção em valores fora do intervalo [0, 9]
    @Property
    boolean addThrowsExceptionForInvalidValues(@ForAll  @IntRange(min = -10, max = 20) int invalidDigit) {
        List<Integer> left = Collections.singletonList(invalidDigit);
        List<Integer> right = Collections.singletonList(0);

        
        
        if (invalidDigit >= 0 && invalidDigit <= 9) {
            List<Integer> result = add.add(left, right);
            return result.equals(Arrays.asList(invalidDigit));
        } else {
            return assertThrows(IllegalArgumentException.class, () -> add.add(left, right)) != null;
        }
    }
}
