package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AddTest {

    // Instância da classe Add
    Add add = new Add();



    // ================================================================================
    // Testes adicionais

    @Test
    void testEntradaNull() {

        // Listas de entrada
        List<Integer> listNull = null;
        List<Integer> list = Arrays.asList(1, 2, 3);


        assertEquals(null, add.add(listNull, list));                    // T01 - left == null
        assertEquals(null, add.add(list, listNull));                    // T02 - right == null
    }



    @Test
    void testEntradaVazia() {

        // Listas de entrada
        List<Integer> listEmpty = Arrays.asList();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        // Resultado esperado
        List<Integer> listRes = Arrays.asList(1, 2, 3);


        assertEquals(listRes, add.add(listEmpty, list1));               // T03 - left.isEmpty()
        assertEquals(listRes, add.add(list2, listEmpty));               // T04 - right.isEmpty()
    }



    @Test
    void testEntradaUnitaria() {

        // Listas de entrada
        List<Integer> listUnitUmNegativo = Arrays.asList(-1);
        List<Integer> listUnitZero = Arrays.asList(0);
        List<Integer> listUnitNove = Arrays.asList(9);
        List<Integer> listUnitDez = Arrays.asList(10);
        List<Integer> list = Arrays.asList(0);


        // LEFT
        assertThrows(IllegalArgumentException.class, () -> add.add(listUnitUmNegativo, list));  // T05 - left[0] == -1
        assertEquals(listUnitZero, add.add(listUnitZero, list));                                // T06 - left[0] == 0
        assertEquals(listUnitNove, add.add(listUnitNove, list));                                // T07 - left[0] == 9
        assertThrows(IllegalArgumentException.class, () -> add.add(listUnitDez, list));         // T08 - left[0] == 10


        // RIGHT
        assertThrows(IllegalArgumentException.class, () -> add.add(list, listUnitUmNegativo));  // T09 - right[0] == -1
        assertEquals(listUnitZero, add.add(list, listUnitZero));                                // T10 - right[0] == 0
        assertEquals(listUnitNove, add.add(list, listUnitNove));                                // T11 - right[0] == 9
        assertThrows(IllegalArgumentException.class, () -> add.add(list, listUnitDez));         // T12 - right[0] == 10
    }



    @Test
    void testEntradaPadrao() {

        // Listas de entrada
        List<Integer> listComUmNegativo1 = Arrays.asList(-1, 0, 1, 2, 3);
        List<Integer> listComUmNegativo2 = Arrays.asList(-1, 0, 1, 2, 3);
        List<Integer> listComZero1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> listComZero2 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> listComNove1 = Arrays.asList(5, 6, 7, 8, 9);
        List<Integer> listComNove2 = Arrays.asList(5, 6, 7, 8, 9);
        List<Integer> listComDez1 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> listComDez2 = Arrays.asList(6, 7, 8, 9, 10);

        List<Integer> list1 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list2 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list3 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list4 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list5 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list6 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list7 = Arrays.asList(1, 0, 0, 0, 0);
        List<Integer> list8 = Arrays.asList(1, 0, 0, 0, 0);


        // Resultado esperado
        List<Integer> listRes1 = Arrays.asList(1, 1, 2, 3, 4);
        List<Integer> listRes2 = Arrays.asList(6, 6, 7, 8, 9);


        // LEFT
        assertThrows(IllegalArgumentException.class, () -> add.add(listComUmNegativo1, list1));     // T13 - left[n] == -1
        assertEquals(listRes1, add.add(listComZero1, list2));                                       // T14 - left[n] == 0
        assertEquals(listRes2, add.add(listComNove1, list3));                                       // T15 - left[n] == 9
        assertThrows(IllegalArgumentException.class, () -> add.add(listComDez1, list4));            // T16 - left[n] == 10


        // RIGHT
        assertThrows(IllegalArgumentException.class, () -> add.add(list5, listComUmNegativo2));     // T17 - right[n] == -1
        assertEquals(listRes1, add.add(list6, listComZero2));                                       // T18 - right[n] == 0
        assertEquals(listRes2, add.add(list7, listComNove2));                                       // T19 - right[n] == 9
        assertThrows(IllegalArgumentException.class, () -> add.add(list8, listComDez2));            // T20 - right[n] == 10
    }



    @Test
    void testValorUnidadeGrande() {

        // Listas de entrada
        List<Integer> listUnidadeGrande1 = Arrays.asList(1, 6);
        List<Integer> listUnidadeGrande2 = Arrays.asList(1, 6);
        List<Integer> listDezenaGrande1 = Arrays.asList(9, 9);
        List<Integer> listDezenaGrande2 = Arrays.asList(9, 9);

        // Resultado esperado
        List<Integer> listRes1 = Arrays.asList(3, 2);
        List<Integer> listRes2 = Arrays.asList(1, 9, 8);


        // Testes
        assertEquals(listRes1, add.add(listUnidadeGrande1, listUnidadeGrande2));        // T21 - left == [1, 6] e right == [1, 6]
        assertEquals(listRes2, add.add(listDezenaGrande1, listDezenaGrande2));          // T22 - left == [9, 9] e right == [9, 9]
    }



    @Test
    void testNumerosComprimentosDiferentes() {

        // Listas de entrada
        List<Integer> listCurta1 = Arrays.asList(1, 2, 3);
        List<Integer> listCurta2 = Arrays.asList(1, 2, 3);
        List<Integer> listLonga1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> listLonga2 = Arrays.asList(1, 2, 3, 4);

        // Resultado esperado
        List<Integer> listRes = Arrays.asList(1, 3, 5, 7);


        // Testes
        assertEquals(listRes, add.add(listLonga1, listCurta1));                // T23 - left.size() > right.size()
        assertEquals(listRes, add.add(listCurta2, listLonga2));                // T24 - left.size() < right.size()
    }




    // ================================================================================
    // Testes padrões do projeto

    @Test
    void testAddTwoOneDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1);
        List<Integer> right = Arrays.asList(1);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(2), result);        
    }

    @Test
    void testAddTwoDoubleDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(1,5);
        List<Integer> right = Arrays.asList(1,0);

        List<Integer> result = add.add(left, right);

        assertEquals(result, result);        
    }

    @Test
    void testAddTwoTreeDigitNumbers() {
        Add add = new Add();

        List<Integer> left = Arrays.asList(5,0,0);
        List<Integer> right = Arrays.asList(2,5,0);

        List<Integer> result = add.add(left, right);

        assertEquals(Arrays.asList(7,5,0), result);
    }
}
