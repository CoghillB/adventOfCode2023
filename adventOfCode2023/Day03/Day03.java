package Day03;
import java.util.*;
import java.io.IOException;
import AdventUtilities.*;

public class Day03{

public class Main {
public static void main(String[] args) throws IOException {
	ArrayList<String> input = AdventUtilities.readLines("Day03/Day03.txt");
	System.out.println(sumPartNumbers(input));
}

public static int sumPartNumbers(ArrayList<String> schematic) {
    int sum = 0;
    int rows = schematic.size();
    int cols = schematic.get(0).length();
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (!Character.isDigit(schematic.get(i).charAt(j)) && schematic.get(i).charAt(j) != '.') {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int nx = i + dx;
                        int ny = j + dy;
                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && Character.isDigit(schematic.get(nx).charAt(ny))) {
                            StringBuilder number = new StringBuilder();
                            while (ny < cols && Character.isDigit(schematic.get(nx).charAt(ny))) {
                                number.append(schematic.get(nx).charAt(ny));
                                ny++;
                            }
                            sum += Integer.parseInt(number.toString());
                        }
                    }
                }
            }
        }
    }
    return sum;
}
}
}