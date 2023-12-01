
package Day01;

import java.util.*;
import java.io.IOException;
import AdventUtilities.*;

public class Day01 {
	public static void main(String[] args) throws IOException {

		ArrayList<String> input = AdventUtilities.readLines("Day01/Day01.txt");
		int sum = 0;
		for (String line : input) {
			int firstNumber = -1;
			int lastNumber = -1;
			for (int j = 0; j < line.length(); j++) {
				if (Character.isDigit(line.charAt(j))) {
					firstNumber = Character.getNumericValue(line.charAt(j));
					break;
				}
			}
			for (int j = line.length() - 1; j >= 0; j--) {
				if (Character.isDigit(line.charAt(j))) {
					lastNumber = Character.getNumericValue(line.charAt(j));
					break;
				}
			}
			if (firstNumber != -1 && lastNumber != -1) {
				sum += firstNumber * 10 + lastNumber;
			}
		}
		System.out.println(sum);
	}
}
