package PartV;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * RealPharma represents a pharmacy system that manages medicines, their associated conditions,
 * and their stock.
 */
public class RealPharma {
    // Map to store the conditions treated by each medicine
    private Map<String, Set<String>> medicineToConditions;
    // Map to store the stock of each medicine
    private Map<String, Integer> medicineStock;

    /**
     * Constructs a RealPharma instance with empty medicine-to-conditions and medicine stock maps.
     * Initializes the medicine-to-conditions and stock for the Aspirin medicine.
     */
    public RealPharma() {
        medicineToConditions = new HashMap<>();
        medicineStock = new HashMap<>();
        
        // Initialize conditions treated by Aspirin
        Set<String> aspirinConditions = new HashSet<>();
        aspirinConditions.add("fever");
        aspirinConditions.add("pain");
        aspirinConditions.add("blood clots");
        // Assign conditions to Aspirin medicine
        medicineToConditions.put("Aspirin", aspirinConditions);
        // Initialize stock for Aspirin
        medicineStock.put("Aspirin", 20);
    }

    /**
     * Retrieves the conditions treated by the specified medicine.
     *
     * @param medicine the name of the medicine
     * @return a set of conditions treated by the medicine
     */
    public Set<String> getConditionsForMedicine(String medicine) {
        return medicineToConditions.get(medicine);
    }

    /**
     * Retrieves the stock quantity of the specified medicine.
     *
     * @param medicine the name of the medicine
     * @return the stock quantity of the medicine
     */
    public int getStockForMedicine(String medicine) {
        return medicineStock.getOrDefault(medicine, 0);
    }

    /**
     * Main method to demonstrate the functionality of the RealPharma class.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        // Create a RealPharma instance
        RealPharma realPharmacy = new RealPharma();
        // Display conditions treated by Aspirin
        System.out.println("Conditions treated by Aspirin: " + realPharmacy.getConditionsForMedicine("Aspirin"));
        // Display stock of Aspirin
        System.out.println("Stock of Aspirin: " + realPharmacy.getStockForMedicine("Aspirin"));
    }
}