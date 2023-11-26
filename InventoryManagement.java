import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagement {

    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        initializeInventory(inventory);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Allen Stores!");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayInventory(inventory);
                    break;
                case 2:
                    purchaseItems(inventory, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using Allen Stores Inventory Management!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void initializeInventory(Map<String, Integer> inventory) {
        // Initialize the inventory with items and initial stock
        // Change or add items as needed
        inventory.put("Item1", 100);
        inventory.put("Item2", 80);
        // ... Add more items
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display Inventory");
        System.out.println("2. Purchase Items");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

    private static void displayInventory(Map<String, Integer> inventory) {
        System.out.println("\nInventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - Stock: " + entry.getValue());
        }
    }

    private static void purchaseItems(Map<String, Integer> inventory, Scanner scanner) {
        System.out.println("\nPurchase Items:");
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        if (inventory.containsKey(itemName)) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            int availableStock = inventory.get(itemName);

            if (quantity <= availableStock) {
                inventory.put(itemName, availableStock - quantity);
                System.out.println("Items purchased successfully!");
                if (availableStock - quantity < 50) {
                    System.out.println("Stock is below 50. Please restock soon.");
                }
                System.out.println("Total cost: " + calculateCost(itemName, quantity));
            } else {
                System.out.println("Insufficient stock.");
            }
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    private static double calculateCost(String itemName, int quantity) {
        // Replace with actual prices for items
        Map<String, Double> prices = new HashMap<>();
        prices.put("Item1", 10.0);
        prices.put("Item2", 15.0);
        // ... Add more items and prices

        if (prices.containsKey(itemName)) {
            return prices.get(itemName) * quantity;
        } else {
            return 0.0;
        }
    }
}

