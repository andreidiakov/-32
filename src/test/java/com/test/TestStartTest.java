package com.test;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestStartTest {
    private ArrayList<Long> numbers;

    @Test
    public void testMin() throws IOException {
        numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
        assertEquals(Long.valueOf( 1), NumberOperations.getMin(numbers));
        System.out.println("Тест на минимум пройден успешно");
    }

    @Test
    public void testMax() throws IOException {
        numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
        assertEquals(Long.valueOf( 10000), NumberOperations.getMax(numbers));
        System.out.println("Тест на максимум пройден успешно");
    }

    @Test
    public void testSum() throws IOException {
        numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
        assertEquals(String.valueOf( 11431), NumberOperations.getSum(numbers));
        System.out.println("Тест на сумму пройден успешно");
    }

    @Test
    public void testMult() throws IOException {
        numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
        assertEquals("8114798039040000", NumberOperations.getMult(numbers));
        System.out.println("Тест на произведение пройден успешно");
    }

    @Disabled
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeoutFail() {
        ArrayList<Long> largeNumbers = new ArrayList<>();
        for (long i = 1; i <= 100000; i++) {
            largeNumbers.add(i);
        }
        NumberOperations.getMult(largeNumbers);
    }
}
