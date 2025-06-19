// src/Search.java

import java.util.*;

public class Search {

    static class Product implements Comparable<Product> {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public int compareTo(Product other) {
            return this.name.compareToIgnoreCase(other.name);
        }
    }

    static List<Product> productList = Arrays.asList(
        new Product("Apple watch", 700),
        new Product("electric brush", 650),
        new Product("Sony speakers", 100),
        new Product("minecraft", 300),
        new Product("colgate tooth paste", 200)
    );

    public static List<Product> linearSearch(String term) {
        List<Product> results = new ArrayList<>();
        for (Product p : productList) {
            if (p.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(p);
            }
        }
        return results;
    }

    public static Product binarySearch(String name) {
        List<Product> sortedList = new ArrayList<>(productList);
        Collections.sort(sortedList);

        int left = 0, right = sortedList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = sortedList.get(mid);
            int cmp = midProduct.name.compareToIgnoreCase(name);

            if (cmp == 0) return midProduct;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose search type: ");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter product name: ");
        String query = scanner.nextLine();

        if (choice == 1) {
            List<Product> results = linearSearch(query);
            if (results.isEmpty()) {
                System.out.println("No results found.");
            } else {
                for (Product p : results) {
                    System.out.printf("%s - $%.2f\n", p.name, p.price);
                }
            }
        } else if (choice == 2) {
            Product result = binarySearch(query);
            if (result == null) {
                System.out.println("Product not found.");
            } else {
                System.out.printf("%s - $%.2f\n", result.name, result.price);
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
