package com.app.interfacee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
* Create and return a Map object that contains the answers when the two values are added, subtracted, multiplied, or divided. Each item in the map should have a String key using one of the already declared constants: ADD, SUBTRACT, MULTIPLY or DIVIDE. The map item's associated value should be an instance of the Float class that contains the result of that mathematical operation.

Use lambda expressions to represent each mathematical operation. Each of the lambda expressions should be wrapped in an instance of Java's BiFunction interface, which is declared with this signature:

Interface BiFunction<T,U,R>
Parameters:
T:  The type of the first argument to the function
U:  The type of the second argument to the function
R:  The type of the result of the function
* */
public class BiFunctionMathDemo {
    private static final Logger logger = LoggerFactory.getLogger(BiFunctionMathDemo.class);
    public static final String ADD = "ADD";
    public static final String SUBTRACT = "SUBTRACT";
    public static final String MULTIPLY = "MULTIPLY";
    public static final String DIVIDE = "DIVIDE";

    public static void main(String[] args) {

        float value1 = 10.0f;
        float value2 = 5.0f;

        // Create a map with lambda expressions for mathematical operations
        Map<String, BiFunction<Float, Float, Float>> operationMap = new HashMap<>();
        operationMap.put(ADD, (a, b) -> a+b);
        operationMap.put(SUBTRACT, (a, b) -> a-b);
        operationMap.put(MULTIPLY, (a, b)-> a*b);
        operationMap.put(DIVIDE, (a,b) -> a/b);

        logger.info("Additions Results: {}", calculate(operationMap.get(ADD), value1, value2));
        logger.info("Subtractions Results: {}", calculate(operationMap.get(SUBTRACT), value1, value2));
        logger.info("Multiplication Results: {}", calculate(operationMap.get(MULTIPLY), value1, value2));
        logger.info("Division Results: {}", calculate(operationMap.get(DIVIDE), value1, value2));
    }

    // Helper method to calculate and return the result of a mathematical operation
    private static Float calculate(BiFunction<Float, Float, Float> operation,
                                   float value1, float value2) {

        return operation.apply(value1, value2);
    }

    public static Map<String, Float> calculate(float value1, float value2) {

        // Your code goes here
        // Create 4 instances of the BiFunction interface referencing lambda expressions
        BiFunction<Float, Float, Float> add = (a, b) -> a + b;
        BiFunction<Float, Float, Float> sub = (a, b) -> a - b;
        BiFunction<Float, Float, Float> mul = (a, b) -> a * b;
        BiFunction<Float, Float, Float> div = (a, b) -> a / b;

        // Map object for holding the results
        Map<String, Float> results = new HashMap<>();

        // Populate the map here with the results of the 4 math operations
        results.put(ADD, add.apply(value1, value2));
        results.put(SUBTRACT, sub.apply(value1, value2));
        results.put(MULTIPLY, mul.apply(value1, value2));
        results.put(DIVIDE, div.apply(value1, value2));

        return results;
    }
}
