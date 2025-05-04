package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("\n0 - Quit, 1 - Add Items, 2 - Remove Items");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> quit = true;
                case 1 -> {
                    System.out.println("Enter item(s) to add (comma-separated):");
                    String input = scanner.nextLine();
                    addItems(input);
                }
                case 2 -> {
                    System.out.println("Enter item(s) to remove (comma-separated):");
                    String input = scanner.nextLine();
                    removeItems(input);
                }
                default -> System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        groceryList.forEach(System.out::println);
    }
}
