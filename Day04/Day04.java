package Day04;
import java.util.*;
import java.io.IOException;
import AdventUtilities.*;
// program runs through lottery ticket and checks it against the winning numbers. If any of the numbers match the winning
// numbers, the program returns the number of matching numbers
public class Day04{
	public static void main(String[] args) throws IOException {
		ArrayList<String> input = AdventUtilities.readLines("Day04/Day04.txt");
		int valid = 0;
		for (String line : input) {
			if (isValid(line)) {
				valid++;
			}
		}
		System.out.println(valid);	

	}

	public static boolean isValid(String line) {
		String[] fields = line.split(" ");
		HashSet<String> fieldNames = new HashSet<String>();
		for (String field : fields) {
			fieldNames.add(field.split(":")[0]);
		}
		if (fieldNames.size() == 8) {
			return true;
		}
		if (fieldNames.size() == 7 && !fieldNames.contains("cid")) {
			return true;
		}
		return false;
	}
}