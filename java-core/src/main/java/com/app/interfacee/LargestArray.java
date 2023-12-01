package com.app.interfacee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.OptionalInt;

// Find the largest number in the array
public class LargestArray {
    private static final Logger logger = LoggerFactory.getLogger(LargestArray.class);
    public static void main(String[] args) {
        int[] numbers = {2,5,6, 9, 15, 69, 90, 55, 5};
        try {
            String result = Integer.toString(findLargest(numbers));
            logger.info(result);
        } catch (IllegalArgumentException exception) {
            logger.error(exception.getMessage());
        }
    }

    static int findLargest(int[] numbers) {

        OptionalInt maxOptional = Arrays.stream(numbers).max();

        if (maxOptional.isPresent()) {
            return maxOptional.getAsInt();
        } else {
            // Handle the case where the array is empty
            throw new IllegalArgumentException("Array is empty");
        }
    }
}
