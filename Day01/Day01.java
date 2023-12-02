package Day01;

import java.util.ArrayList;
import java.io.IOException;
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

    private static int findFirstNumber(String line) {
        StringBuilder digits = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else if (Character.isLetter(c)) {
                int wordValue = getWordValue(Character.toString(c));
                if (wordValue != 0) {
                    digits.append(wordValue);
                    break; // Stop after finding the first digit
                }
            }
        }

        return digits.length() == 1 ? Integer.parseInt(digits.toString()) : 0;
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
                return 0;
        }
    }
}
