package PartV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProfessionalPharmacy class represents a pharmacy that manages medicines and their stock for various medical conditions.
 */
public class ProfessionalPharmacy {
    // Map to store medicines and their stock for each medical condition
    private Map<String, Map<String, Integer>> conditionToMedicinesAndStock;

    /**
     * Constructor to initialize the ProfessionalPharmacy object.
     * It populates the conditionToMedicinesAndStock map with initial data.
     */
    public ProfessionalPharmacy() {
        conditionToMedicinesAndStock = new HashMap<>();

        // Adding medicines for stomach flu
        Map<String, Integer> stomachFluMeds = new HashMap<>();
        stomachFluMeds.put("Pepto-Bismol", 5);
        stomachFluMeds.put("Imodium", 8);
        conditionToMedicinesAndStock.put("stomach flu", stomachFluMeds);

        // Add more conditions and medicines as needed
    }

    /**
     * Retrieves the list of medicines available for a given medical condition.
     * @param condition The medical condition for which medicines are required.
     * @return A list of medicines available for the specified condition, or null if the condition is not found.
     */
    public List<String> getMedicinesForCondition(String condition) {
        Map<String, Integer> medicinesWithStock = conditionToMedicinesAndStock.get(condition);
        if (medicinesWithStock != null) {
            return new ArrayList<>(medicinesWithStock.keySet());
        }
        return null; // Condition not found
    }

    /**
     * Retrieves the stock quantity of a specific medicine for a given medical condition.
     * @param condition The medical condition.
     * @param medicine The name of the medicine.
     * @return The stock quantity of the specified medicine for the given condition,
     *         or 0 if the condition or medicine is not found.
     */
    public int getStockForMedicine(String condition, String medicine) {
        Map<String, Integer> medicinesWithStock = conditionToMedicinesAndStock.get(condition);
        if (medicinesWithStock != null) {
            Integer stock = medicinesWithStock.get(medicine);
            return stock != null ? stock : 0; // If medicine not found, return 0
        }
        return 0; // Condition not found
    }

    /**
     * Main method to demonstrate the usage of the ProfessionalPharmacy class.
     * Creates an instance of ProfessionalPharmacy and performs example operations.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ProfessionalPharmacy natashasPharmacy = new ProfessionalPharmacy();

        // Example: Get medicines for stomach flu
        List<String> stomachFluMeds = natashasPharmacy.getMedicinesForCondition("stomach flu");
        if (stomachFluMeds != null) {
            System.out.println("Medicines for stomach flu: " + stomachFluMeds);
        } else {
            System.out.println("Condition not found.");
        }

        // Example: Get stock for Pepto-Bismol for stomach flu
        int peptoBismolStock = natashasPharmacy.getStockForMedicine("stomach flu", "Pepto-Bismol");
        System.out.println("Stock of Pepto-Bismol for stomach flu: " + peptoBismolStock);
    }
}