import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    // HashMap to store Inventory details
    HashMap<String, Integer> inventory = new HashMap<>();
    HashMap<String, Double> prices = new HashMap<>();

    // Constructor to initialize inventory
    public InventoryManagementSystem() {
        // Initial inventory setup
        inventory.put("Laptop", 10);
        inventory.put("Mouse", 50);
        inventory.put("Keyboard", 30);

        prices.put("Laptop", 1500.00);
        prices.put("Mouse", 30.75);
        prices.put("Keyboard", 65.99);
        }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        // Main menu loop
        while (true) {
            System.out.println("\nInventory Management System:");
            System.out.println("----------------------------");
            System.out.println("1. Add Item");
            System.out.println("2. Set Quantity");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter item price: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid price. Must be a number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    double price = scanner.nextDouble();
                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                        continue;
                    }

                    System.out.print("Enter item quantity: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid quantity. Must be a number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    int quantity = scanner.nextInt();
                    if (quantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                        continue;
                    }
                    ims.inventory.put(name, ims.inventory.getOrDefault(name, 0) + quantity);
                    ims.prices.put(name, price);
                        ims.prices.put(name, price);
                        System.out.println("Item added successfully.");
                        break;
    
                    case 2:
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        if (scanner.hasNextInt()) {
                            int newQuantity = scanner.nextInt();
                            if (newQuantity >= 0) {
                                ims.inventory.put(itemName, newQuantity);
                                System.out.println("Quantity of " + itemName + " set to " + newQuantity);
                            } else {
                                System.out.println("Quantity cannot be negative.");
                            }
                        } else {
                            System.out.println("Invalid quantity. Must be a number.");
                            scanner.next(); // Clear invalid input
                        }
                        break;

                case 3:
                    System.out.printf("\n%-15s %-10s %-10s%n", "Item", "Price", "Quantity");
                    for (Map.Entry<String, Integer> entry : ims.inventory.entrySet()) {
                        System.out.printf("%-15s %-9.2f %-10d%n",
                                entry.getKey(), ims.prices.get(entry.getKey()), entry.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return; // Properly exits the program

                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }
}

// Inventory class to store inventory details
class Inventory {
    private String name;
    private double price;
    private int quantity;

    public Inventory(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int amount) {
        this.quantity += amount;
    }
}