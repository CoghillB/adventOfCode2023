package Day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.lang.reflect.Array;

import AdventUtilities.AdventUtilities;

public class Day01 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = AdventUtilities.readLines("Day01/Day01Test.txt");

        int sum = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            int calibrationValue = extractCalibrationValue(input.get(i), input.get(i + 1));
            sum += calibrationValue;
            System.out.println(input.get(i) + " + " + input.get(i + 1) + " -> " + calibrationValue);
        }

        System.out.println("Sum of calibration values: " + sum);
    }

    private static int extractCalibrationValue(String line1, String line2) {
        int lastValueLine1 = findLastNumber(line1);
        int firstValueLine2 = findFirstNumber(line2);

        int result = lastValueLine1 * 10 + firstValueLine2;
        System.out.println(
                "Last of Line1: " + lastValueLine1 + ", First of Line2: " + firstValueLine2 + ", Result: " + result);

        return result;
    }

    private static int calculateCalibrationSum(String calibrationDocument) {
        // Split the document into lines
        String[] lines = calibrationDocument.split("\n");

        // Initialize sum
        int sum = 0;

        // Iterate through each line
        for (String line : lines) {
            // Extract the real first and last digit
            int value = extractCalibrationValue(line);

            // Add to the sum
            sum += value;
        }

        return sum;
    }

    private static int findLastNumber(String line) {
        StringBuilder digits = new StringBuilder();

        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                digits.insert(0, c);
            } else if (Character.isLetter(c)) {
                int wordValue = getWordValue(Character.toString(c));
                if (wordValue != 0) {
                    digits.insert(0, wordValue);
                    break; // Stop after finding the last digit
                }
            }
        }

        return digits.length() == 1 ? Integer.parseInt(digits.toString()) : 0;
    }

    private static int getWordValue(String word) {
        switch (word.toLowerCase()) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                // If not a spelled-out digit, extract the first and last character
                char firstChar = lowerCaseWord.charAt(0);
                char lastChar = lowerCaseWord.charAt(lowerCaseWord.length() - 1);

                // Convert to digit if both characters are digits
                if (Character.isDigit(firstChar) && Character.isDigit(lastChar)) {
                    return Integer.parseInt("" + firstChar + lastChar);
                } else {
                    return 0; // Not a valid digit
                }
        }
    }
}
