package org.example;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestStartTest {
    private ArrayList<Long> numbers;

    @BeforeAll
    public void init() throws Exception {
        numbers = NumberOperations.readNumbersFromFile("test_numbers.txt");
    }

    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testMin() {
        assertEquals(Long.valueOf( 1), NumberOperations.getMin(numbers));
        System.out.println("Тест на минимум пройден успешно");
    }

    @Test
    public void testMax() {
        assertEquals(Long.valueOf( 10000), NumberOperations.getMax(numbers));
        System.out.println("Тест на максимум пройден успешно");
    }

    @Test
    public void testSum() {
        assertEquals(String.valueOf( 11431), NumberOperations.getSum(numbers));
        System.out.println("Тест на сумму пройден успешно");
    }

    @Test
    public void testMult() {
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
