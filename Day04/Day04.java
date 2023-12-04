package Day04;
import java.util.*;
import java.io.IOException;
import AdventUtilities.*;
/* checks each cards numbers against winning numbers and returns how many numbers matched on each line
 * then adds all the numbers together and returns the total
 */
public class Day04 {
	public static void main(String[] args) throws IOException {
	ArrayList<String> input = AdventUtilities.readLines("C:\\Users\\coghi\\OneDrive\\Documents\\AdventOfCode\\adventOfCode2023\\Day04\\Day04.txt");
	int total = 0;
	for (String line : input) {
		String[] parts = line.split(":");
		String[] numbersParts = parts[1].trim().split("\\|");
		String[] winningNumbersStr = numbersParts[0].trim().split(" ");
		String[] yourNumbersStr = numbersParts[1].trim().split(" ");
		Set<Integer> winningNumbers = new HashSet<>();
		for (String num : winningNumbersStr) {
			if (!num.isEmpty()) {
				winningNumbers.add(Integer.parseInt(num));
			}
		}
		Set<Integer> yourNumbers = new HashSet<>();
		for (String num : yourNumbersStr) {
			if (!num.isEmpty()) {
				yourNumbers.add(Integer.parseInt(num));
			}
		}
		Set<Integer> intersection = new HashSet<>(winningNumbers);
		intersection.retainAll(yourNumbers);
		int score = intersection.size() > 0 ? (int) Math.pow(2, intersection.size() - 1) : 0;
		total += score;
	}
	System.out.println(total);
	}
}