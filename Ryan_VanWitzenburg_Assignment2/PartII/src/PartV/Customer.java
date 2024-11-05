package PartV;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * Represents a customer with a shopping basket.
 */
public class Customer {
    private Bag<String> basket; // A bag to store prescriptions in the customer's basket

    /**
     * Constructs a new Customer object with an empty basket.
     */
    public Customer() {
        basket = new HashBag<>(); // Instantiate a new HashBag for the basket
    }

    /**
     * Adds a prescription to the customer's basket.
     *
     * @param prescription The prescription to add to the basket.
     */
    public void addToBasket(String prescription) {
        basket.add(prescription); // Add the prescription to the basket
    }

    /**
     * Removes a prescription from the customer's basket.
     *
     * @param prescription The prescription to remove from the basket.
     */
    public void removeFromBasket(String prescription) {
        basket.remove(prescription); // Remove the prescription from the basket
    }

    /**
     * Displays the contents of the customer's basket.
     */
    public void displayBasket() {
        System.out.println("Garnet's Basket:");
        // Iterate through unique prescriptions in the basket and display them with counts
        for (String prescription : basket.uniqueSet()) {
            int count = basket.getCount(prescription);
            System.out.println(prescription + ": " + count);
        }
    }

    /**
     * Main method to demonstrate the functionality of the Customer class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new customer object
        Customer garnet = new Customer();
        // Add some prescriptions to the customer's basket
        garnet.addToBasket("Xanax");
        garnet.addToBasket("Metformin");
        garnet.addToBasket("Metformin");
        garnet.addToBasket("Metformin");

        // Display the contents of the customer's basket
        garnet.displayBasket();
    }
}