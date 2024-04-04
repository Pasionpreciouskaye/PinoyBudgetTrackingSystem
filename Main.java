package PinoyBudget;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BudgetTracker tracker = new BudgetTracker();
            boolean running = true;

            while (running) {
                System.out.println("\n1. Add Budget\n2. View Budgets\n3. Exit");
                System.out.print("Enter your choice: ");
                int choice = 0;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter budget name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter budget amount: ");
                        double amount = 0;
                        try {
                            amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline character
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for amount. Please enter a number.");
                            scanner.nextLine(); // Clear buffer
                            continue;
                        }
                        System.out.print("Enter budget category: ");
                        String category = scanner.nextLine();
                        tracker.addBudget(name, amount, category);
                        break;
                    case 2:
                        System.out.println("Budgets:");
                        tracker.viewBudgets();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}