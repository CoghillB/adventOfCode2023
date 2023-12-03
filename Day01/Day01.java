package Day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.lang.reflect.Array;

import AdventUtilities.AdventUtilities;
import java.io.IOException;

public class Day01 {
    public static void main(String[] args) {

    // ...

    try {
        ArrayList<String> input = AdventUtilities.readLines("Day01/Day01.txt");

        // Input the calibration document
        System.out.println("Enter the calibration document (press Enter twice to finish):");
        StringBuilder calibrationDocument = new StringBuilder();
        String line;
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).isEmpty()) {
            calibrationDocument.append(line).append("\n");
        }

        // Calculate the sum of calibration values
        int sum = calculateCalibrationSum(calibrationDocument.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Display the result
    System.out.println("The sum of all calibration values is: " + sum);
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

    private static int extractCalibrationValue(String line) {
        // Split the line into words
        String[] words = line.split("\\s+");

        // Initialize the value
        int value = 0;

        // Iterate through each word
        for (String word : words) {
            // Extract the real digits from the word
            int digit = extractDigitFromWord(word);

            // Combine with the existing value
            value = value * 10 + digit;
        }

        return value;
    }

    private static int extractDigitFromWord(String word) {
        // Convert word to lowercase for case-insensitivity
        String lowerCaseWord = word.toLowerCase();

        // Check if the word represents a digit
        switch (lowerCaseWord) {
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
