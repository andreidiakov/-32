package com.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeTests {

    public static void main(String[] args) {
        testPerformance();
    }
    public static void testPerformance() {
        int[] sizes = {100, 10000, 100000, 500000, 1000000};
        for (int size : sizes) {
            ArrayList<Long> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                numbers.add((long)(Math.random() * 1000));
            }
            long startTime = System.nanoTime();
            NumberOperations.getMax(numbers);
            long endTime = System.nanoTime();
            long duration_max = (endTime - startTime)/1000000;
            startTime = System.nanoTime();
            NumberOperations.getMin(numbers);
            endTime = System.nanoTime();
            long duration_min = (endTime - startTime)/1000000;
            startTime = System.nanoTime();
            NumberOperations.getMult(numbers);
            endTime = System.nanoTime();
            long duration_mult = (endTime - startTime)/1000000;
            startTime = System.nanoTime();
            NumberOperations.getSum(numbers);
            endTime = System.nanoTime();
            long duration_sum = (endTime - startTime)/1000000;
            System.out.println("Size: " + size + " Time_max: " + duration_max + " ms; Time_min:" + duration_min +
                    " ms; Time_mult: " + duration_mult + " ms; Time_sum: " + duration_sum + " ms." );
        }

    }
}
//Size: 100, Time_mult: 1 ms; Time_sum: 0 ms
//Size: 10000, Time_mult: 11 ms; Time_sum: 2 ms
//Size: 100000, Time_mult: 13 ms; Time_sum: 10 ms
//Size: 500000, Time_mult: 54 ms; Time_sum: 43 ms
//Size: 1000000, Time_mult: 87 ms; Time_sum: 72 ms