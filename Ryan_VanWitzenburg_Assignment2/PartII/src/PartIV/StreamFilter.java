package PartIV;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

/**
 * The StreamFilter class provides methods to filter a list of animal pairs based on height.
 */
public class StreamFilter {
	
    /**
     * Entry point of the program to demonstrate the usage of StreamFilter class.
     * Creates a list of animal pairs and filters out animals with height over 50 units.
     * Prints the result to the console.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Pair<String, Integer>> animals = Arrays.asList(
                Pair.of("Parrot", 32),
                Pair.of("Rhinoceros", 250),
                Pair.of("Fly", 2),
                Pair.of("Fly", 3),
                Pair.of("Parrot", 65)
        );

        List<String> result = StreamFilter.getAnimals(animals);
        System.out.println("Animals over 50 in height: " + result);
    }
	
    /**
     * Filters a list of animal pairs to get the names of animals with height over 50 units.
     *
     * @param animals a list of animal pairs where each pair contains the name of the animal and its height
     * @return a list of names of animals with height over 50 units
     */
    public static List<String> getAnimals(List<Pair<String, Integer>> animals) {
        return animals.stream()
                      .filter(pair -> pair.getValue() > 50) // Filter animals with height over 50
                      .map(Pair::getKey) // Extract the names of animals
                      .collect(Collectors.toList()); // Collect the names into a list
    }
}