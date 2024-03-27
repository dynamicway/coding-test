package me.study.solvedac;

import me.study.CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Problem14888 implements CodingTest {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        READER.readLine();
        String[] operandSource = READER.readLine().split(" ");
        List<Integer> operands = new ArrayList<>();
        for (final String source : operandSource) {
            operands.add(Integer.parseInt(source));
        }
        String[] operatorSource = READER.readLine().split(" ");
        List<Integer> operatorsCount = new ArrayList<>();
        for (final String source : operatorSource) {
            operatorsCount.add(Integer.parseInt(source));
        }
        List<Integer> results = solve(operands, operatorsCount);
        WRITER.write(results.get(0) + " ");
        WRITER.write(String.valueOf(results.get(1)));
        WRITER.flush();
        WRITER.close();
        READER.close();
    }

    private static Integer max;
    private static Integer min;
    private static List<String> operators;
    private static List<Integer> operands;

    public static List<Integer> solve(List<Integer> operands, List<Integer> operatorsCount) {
        operators = getOperators(operatorsCount);
        Problem14888.operands = operands;
        for (int i = 0; i < operators.size(); i++) {
            ArrayList<Integer> currentOperatorIndexes = new ArrayList<>();
            currentOperatorIndexes.add(i);
            recursive(currentOperatorIndexes, operators.size());
        }
        return List.of(max, min);
    }

    private static void recursive(ArrayList<Integer> currentOperatorIndexes, int operatorsThreshold) {
        if (currentOperatorIndexes.size() == operatorsThreshold) {
            int result = calculateOperands(currentOperatorIndexes);
            calculateMaxAndMin(result);
        } else {
            for (int i = 0; i < operatorsThreshold; i++) {
                if (!currentOperatorIndexes.contains(i)) {
                    ArrayList<Integer> nextOperatorIndexes = new ArrayList<>(currentOperatorIndexes);
                    nextOperatorIndexes.add(i);
                    recursive(nextOperatorIndexes, operatorsThreshold);
                }
            }
        }
    }

    private static void calculateMaxAndMin(int result) {
        if (max == null) {
            max = result;
        } else {
            max = Math.max(max, result);
        }
        if (min == null) {
            min = result;
        } else {
            min = Math.min(min, result);
        }
    }

    private static int calculateOperands(ArrayList<Integer> currentOperatorIndexes) {
        int result = operands.get(0);
        for (int i = 0; i < currentOperatorIndexes.size(); i++) {
            final Integer currentOperatorIndex = currentOperatorIndexes.get(i);
            int nextOperand = operands.get(i + 1);
            result = switch (operators.get(currentOperatorIndex)) {
                case "+" -> result + nextOperand;
                case "-" -> result - nextOperand;
                case "*" -> result * nextOperand;
                case "/" -> result / nextOperand;
                default -> throw new IllegalArgumentException();
            };
        }
        return result;
    }

    private static List<String> getOperators(List<Integer> operatorsCount) {
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String operator = switch (i) {
                case 0 -> "+";
                case 1 -> "-";
                case 2 -> "*";
                case 3 -> "/";
                default -> throw new IllegalStateException();
            };
            for (int j = 0; j < operatorsCount.get(i); j++) {
                operators.add(operator);
            }
        }

        return operators;
    }

    @Override
    public String getTimeComplexity() {
        return "O(N!)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }

    @Override
    public String getPage() {
        return "https://www.acmicpc.net/problem/14888";
    }
}
