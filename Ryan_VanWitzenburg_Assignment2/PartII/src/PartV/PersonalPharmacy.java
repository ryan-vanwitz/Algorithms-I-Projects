package PartV;

import java.util.HashMap;
import java.util.Map;

/**
 * The PersonalPharmacy class represents a personal pharmacy system
 * that maps medical conditions to corresponding medications.
 */
public class PersonalPharmacy {
    // HashMap to store medical conditions and corresponding medications
    private Map<String, String> conditionToMedicine;

    /**
     * Constructs a PersonalPharmacy object and initializes the conditionToMedicine map.
     * Pre-populates the map with default condition-to-medication mappings.
     */
    public PersonalPharmacy() {
        conditionToMedicine = new HashMap<>();
        // Pre-populating the map with default condition-to-medication mappings
        conditionToMedicine.put("stomach flu", "Imodium");
        conditionToMedicine.put("headache", "Advil");
        conditionToMedicine.put("fever", "Aspirin");
    }

    /**
     * Retrieves the medication associated with a given medical condition.
     * @param condition The medical condition for which medication is needed.
     * @return The medication corresponding to the provided condition.
     */
    public String getMedicineForCondition(String condition) {
        return conditionToMedicine.get(condition);
    }

    /**
     * The main method demonstrates the usage of the PersonalPharmacy class.
     * Creates a PersonalPharmacy object and retrieves medication for a specific condition.
     * Prints the medication for the condition to the console.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating a PersonalPharmacy object
        PersonalPharmacy judysPharmacy = new PersonalPharmacy();
        // Retrieving medication for a specific condition and printing it to the console
        System.out.println("Medicine for headache: " + judysPharmacy.getMedicineForCondition("headache"));
    }
}