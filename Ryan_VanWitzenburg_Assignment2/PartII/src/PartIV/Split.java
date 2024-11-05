package PartIV;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

/**
 * The Split class demonstrates how to partition a list of animal names based on their heights.
 */
public class Split {
    
    /**
     * The main method creates a list of animal names paired with their heights, partitions the list
     * into two groups based on height thresholds (below 50 and 50 and above), and prints the results.
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a list of animal names paired with their heights
        List<Pair<String, Integer>> animals = Arrays.asList(
                Pair.of("Parrot", 32),
                Pair.of("Rhinoceros", 250),
                Pair.of("Fly", 2),
                Pair.of("Fly", 3),
                Pair.of("Parrot", 65)
        );

        // Partition the list based on height thresholds
        Map<Boolean, List<String>> result = Split.splitter(animals);
        List<String> below50 = result.get(false);
        List<String> above50 = result.get(true);

        // Print the partitioned results
        System.out.println("Animals with heights below 50: " + below50);
        System.out.println("Animals with heights 50 and over: " + above50);
    }
    
    /**
     * Splits the list of animal names based on their heights.
     * Animals with heights below 50 are grouped separately from those with heights 50 and above.
     * @param animals A list of animal names paired with their heights.
     * @return A map containing two lists: one for animals below 50 and one for animals 50 and above.
     */
    public static Map<Boolean, List<String>> splitter(List<Pair<String, Integer>> animals) {
        return animals.stream()
                      .collect(Collectors.partitioningBy(pair -> pair.getValue() >= 50,
                                                         Collectors.mapping(Pair::getKey, Collectors.toList())));
    }
}