package PartIV;

import java.util.Arrays;
import java.util.List;

/**
 * The StreamFlat class demonstrates the use of Java streams and flatMap operation
 * to process a nested list of grades and count the number of grades strictly larger than 85.
 */
public class StreamFlat {
    
    /**
     * The main method serves as an entry point to the program.
     * It creates a list of lists representing grades, processes them using
     * the getGoodGrades method, and prints the result.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Define a list of lists representing grades
        List<List<Integer>> grades = Arrays.asList(
                Arrays.asList(87, 85, 75, 91),
                Arrays.asList(88, 82, 79, 89),
                Arrays.asList(65, 52, 49, 60)
        );

        // Count the number of grades strictly larger than 85
        long result = StreamFlat.getGoodGrades(grades);
        
        // Print the result
        System.out.println("Number of grades strictly larger than 85: " + result);
    }
    
    /**
     * The getGoodGrades method processes a nested list of grades using Java streams.
     * It flattens the nested lists into a single stream, filters grades larger than 85,
     * and counts the occurrences of such grades.
     *
     * @param grades a list of lists representing grades
     * @return the number of grades strictly larger than 85
     */
    public static long getGoodGrades(List<List<Integer>> grades) {
        return grades.stream()                    // Convert the list to a stream of lists
                     .flatMap(List::stream)       // Flatten the nested lists into a single stream
                     .filter(grade -> grade > 85) // Filter grades larger than 85
                     .count();                    // Count the occurrences of such grades
    }
}