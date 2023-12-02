package Day02;

import java.util.*;
import java.io.IOException;
import AdventUtilities.*;

public class Day02 {
	public static void main(String[] args) throws IOException {
		ArrayList<String> input = AdventUtilities.readLines("Day02/Day02.txt");
		int totalPower = getTotalPower(input);
		System.out.println("Part 2: " + totalPower);
	}

	private static int getTotalPower(List<String> inputLines) {
		int totalPower = 0;
		for (String line : inputLines) {
			String[] parts = line.split(": ");
			String[] subsets = parts[1].split("; ");
			int minRed = 0, minGreen = 0, minBlue = 0;
			for (String subset : subsets) {
				String[] words = subset.split(", ");
				int red = 0, green = 0, blue = 0;
				for (String word : words) {
					if (word.contains("red")) {
						red = Integer.parseInt(word.split(" ")[0]);
					} else if (word.contains("green")) {
						green = Integer.parseInt(word.split(" ")[0]);
					} else if (word.contains("blue")) {
						blue = Integer.parseInt(word.split(" ")[0]);
					}
				}
				minRed = Math.max(minRed, red);
				minGreen = Math.max(minGreen, green);
				minBlue = Math.max(minBlue, blue);
			}
			totalPower += minRed * minGreen * minBlue;
		}
		return totalPower;
	}
}