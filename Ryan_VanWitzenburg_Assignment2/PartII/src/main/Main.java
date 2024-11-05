package main;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.time.StopWatch;

import structures.RemovalArray;
import implementation.IncrementalArray;
import implementation.SwapingArray;
import implementation.DoublingArray;

/**
 * The Main class contains the main method and other utility methods to perform experiments
 * on different implementations of RemovalArray.
 */
public class Main {

    /**
     * The main method.
     */
    public static void main(String[] args) {

        // Create instances of different RemovalArray implementations
        RemovalArray<Integer> incrementalArray = new IncrementalArray<>();
        RemovalArray<Integer> doublingArray = new DoublingArray<>();
        RemovalArray<Integer> swapingArray = new SwapingArray<>();

        // Perform adding experiments for DoublingArray and SwappingArray
        performAddingExperiments(doublingArray, "doubling.csv");
        // performExperiments(incrementalArray, "incremental.csv");
        performAddingExperiments(swapingArray, "swaping.csv");

        // Test the SwappingArray implementation
        testSwapingArray();

        // Perform removing experiments for DoublingArray and SwappingArray
        performRemovingExperiments(doublingArray, "doublingRemove.csv");
        // performRemovingExperiments(incrementalArray, "incrementalRemove.csv");
        performRemovingExperiments(swapingArray, "swapingRemove.csv");
    }

    /**
     * Utility method to add elements to a RemovalArray instance.
     * 
     * @param arr      The RemovalArray instance
     * @param elements The number of elements to add
     */
    public static void addToArray(RemovalArray<Integer> arr, int elements) {
        for (int i = 1; i <= elements; i++) {
            arr.add(i);
        }
    }

    /**
     * Utility method to measure the time taken to add elements to a RemovalArray instance.
     * 
     * @param arr      The RemovalArray instance
     * @param elements The number of elements to add
     * @return The time taken to add elements in milliseconds
     */
    public static long measureTime(RemovalArray<Integer> arr, int elements) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        addToArray(arr, elements);
        stopWatch.stop();
        return stopWatch.getTime();
    }

    /**
     * Method to perform adding experiments and write the results to a CSV file.
     * 
     * @param arr      The RemovalArray instance
     * @param filename The name of the CSV file to write the results
     */
    public static void performAddingExperiments(RemovalArray<Integer> arr, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("N,Repeat1,Repeat2,Repeat3,Repeat4,Repeat5,Repeat6,Repeat7,Repeat8,Repeat9,Repeat10\n");
            for (int n = 20000; n <= 400000; n += 20000) {
                StringBuilder result = new StringBuilder();
                System.out.println("*");
                result.append(n).append(",44");
                for (int i = 0; i < 10; i++) {
                    if (filename.equals("doubling.csv")) {
                        arr = new DoublingArray<>();
                    } else {
                        arr = new SwapingArray<>();
                    }
                    long time = measureTime(arr, n);
                    double timeInSeconds = time / 1000.0; // Convert time to seconds
                    result.append(timeInSeconds);
                    if (i < 9) {
                        result.append(",");
                    }
                }
                result.append("\n");
                writer.write(result.toString());
            }
            System.out.println("Experiments completed. Results saved in " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Method to test the SwappingArray implementation by adding elements and removing them.
     */
    public static void testSwapingArray() {
        SwapingArray<Integer> array = new SwapingArray<>();

        // Add elements to the array
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);
        array.add(50);

        // Print the array before removal
        System.out.println("Array before removal:");
        printArray(array);

        // Remove element at index 2 (30)
        array.remove(2);

        // Print the array after removal
        System.out.println("\nArray after removal at index 2:");
        printArray(array);

        // Remove element 50
        array.remove(Integer.valueOf(50));

        // Print the array after removal
        System.out.println("\nArray after removal of element 50:");
        printArray(array);
    }
    
    /**
     * Utility method to print the elements of a SwapingArray instance.
     * 
     * @param array The SwapingArray instance to print
     */
    public static void printArray(SwapingArray<Integer> array) {
        // Iterate over the elements of the array
        for (int i = 0; i < array.size(); i++) {
            // Print the element at index i
            System.out.print(array.find(i) + " ");
        }
        // Print a new line after printing all elements
        System.out.println();
    }

    /**
     * Method to perform removing experiments and write the results to a CSV file.
     * 
     * @param arr      The RemovalArray instance
     * @param filename The name of the CSV file to write the results
     */
    public static void performRemovingExperiments(RemovalArray<Integer> arr, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("N,Repeat1,Repeat2,Repeat3,Repeat4,Repeat5,Repeat6,Repeat7,Repeat8,Repeat9,Repeat10\n");
            for (int n = 20000; n <= 400000; n += 20000) {
                StringBuilder result = new StringBuilder();
                System.out.println("*");
                result.append(n).append(",");
                for (int i = 0; i < 10; i++) {
                    if (filename.equals("doublingRemove.csv")) {
                        arr = new DoublingArray<>();
                    } else {
                        arr = new SwapingArray<>();
                    }
                    long time = measureTime(arr, n);
                    double timeInSeconds = time / 1000.0; // Convert time to seconds
                    result.append(timeInSeconds);
                    if (i < 9) {
                        result.append(",");
                    }
                }
                result.append("\n");
                writer.write(result.toString());
            }
            System.out.println("Experiments completed. Results saved in " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}