package AdventUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventUtilities {
    public static void main(String[] args) throws IOException {
        setup();
    }

    // Takes a problem input file name and returns an ArrayList of the file lines.
    public static ArrayList<String> readLines(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        ArrayList<String> output = new ArrayList<>();

        while (input.hasNextLine()) {
            output.add(input.nextLine());
        }

        return output;
    }

    // Reads the characters from the input into one long string, removing any
    // spaces.
    // Typically you will want to use readLines() instead!
    public static String readCharacters(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        StringBuilder output = new StringBuilder();

        while (input.hasNext()) {
            output.append(input.next());
        }

        return output.toString();
    }

    // Creates a folder for each day with a day.java file, an input.txt, and a
    // test.txt.
    public static void setup() throws IOException {
        int[] daysToCreate = new int[25];
        for (int dayNumber = 1; dayNumber <= daysToCreate.length; dayNumber++) {
            String fileName = "Day";
            if (dayNumber < 10)
                fileName += "0";
            fileName += dayNumber;

            File day = new File(fileName + "/" + fileName + ".java");
            File dayInput = new File(fileName + "/" + fileName + ".txt");
            File dayTest = new File(fileName + "/" + fileName + "Test.txt");
            File directory = new File(fileName);

            directory.mkdir();

            if (!day.exists()) {
                day.createNewFile();

                FileWriter dayFile = new FileWriter(fileName + "/" + fileName + ".java");

                String dayFormat = "package " + fileName + ";\n" +
                        "import java.util.*;\n" +
                        "import java.io.IOException;\n" +
                        "import AdventUtilities.*;\n\n" +
                        "public class " + fileName + "{\n" +
                        "\tpublic static void main(String[] args) throws IOException {\n" +
                        "\t\tArrayList<String> input = AdventUtilities.readLines(" +
                        "\"" + fileName + "/" + fileName + ".txt\");\n\t}\n}";

                dayFile.write(dayFormat);

                dayInput.createNewFile();
                dayTest.createNewFile();

                dayFile.close();
            }

        }
    }

}
