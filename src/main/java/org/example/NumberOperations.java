package org.example;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;


public class NumberOperations {

    public static long getMin(ArrayList<Long> numbers) {
    long min = numbers.get(0);

    return min;
}

    public static long getMax(ArrayList<Long> numbers) {
        long max = numbers.get(0);
        for (Long number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static String getSum(ArrayList<Long> numbers) {
        BigInteger sum = new BigInteger("0");
        for (Long number : numbers) {
            sum = sum.add(BigInteger.valueOf(number));
        }
        return String.valueOf(sum);
    }

    public static String getMult(ArrayList<Long> numbers) {
        BigInteger mult = new BigInteger("1");
        for (Long number : numbers) {
            mult = mult.multiply(BigInteger.valueOf(number));
        }
        return String.valueOf(mult);
    }
    public static ArrayList<Long> readNumbersFromFile(String filename) throws IOException {
        ArrayList<Long> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] nums = line.split(" ");
            for (String num : nums) {
                numbers.add(Long.parseLong(num));

            }
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Long> numbers = readNumbersFromFile("test_numbers.txt");
        System.out.println("Минимальное: " + getMin(numbers));
        System.out.println("Максимальное: " + getMax(numbers));
        System.out.println("Сумма: " + getSum(numbers));
        System.out.println("Произведение: " + getMult(numbers));
    }
}