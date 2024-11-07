    package com.university;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AppTest {

    @Test
    public void testSolutionCSVMatchesExpected() {
        String solutionFilePath = "src/main/resources/solution.csv";
        String expectedFilePath = "src/main/resources/expected.csv";

        //Check if solution.csv exists before running the test
        if (Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file exists before the test runs.");
        }

        try {
            App.main(new String[]{});  // Running the App's main method
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute App.main()");
        }

        // Check if solution.csv was created after running the test
        if (!Files.exists(Paths.get(solutionFilePath))) {
            fail("The solution.csv file does not exist after running the test.");
        }

        // Proceed to compare the solution.csv with expected.csv
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(solutionFilePath));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader.readLine()) != null && 
                   (expectedLine = expectedReader.readLine()) != null) {
                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
            }
            
            // Ensure both files have the same number of lines
            assertEquals(solutionReader.readLine(), expectedReader.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSolutionCSVMatchesExpected2() {
        String solutionFilePath2 = "src/main/resources/solution_2.csv";
        String expectedFilePath2 = "src/main/resources/expected_2.csv";
        try (BufferedReader solutionReader2 = new BufferedReader(new FileReader(solutionFilePath2));
             BufferedReader expectedReader2 = new BufferedReader(new FileReader(expectedFilePath2))) {

            String solutionLine;
            String expectedLine;

            while ((solutionLine = solutionReader2.readLine()) != null &&
                    (expectedLine = expectedReader2.readLine()) != null) {
                assertEquals(expectedLine, solutionLine, "Mismatch found in the CSV file content.");
            }

            // Ensure both files have the same number of lines
            assertEquals(solutionReader2.readLine(), expectedReader2.readLine(), "Files have different number of lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
