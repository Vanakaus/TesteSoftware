package edu.utfpr;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AddTest {

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
