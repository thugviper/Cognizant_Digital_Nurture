// src/Search.java

import java.util.*;

public class Search {

    static class Product implements Comparable<Product> {
         int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
    }

    static List<Product> productList = Arrays.asList(
        new Product(101, "Apple iPhone 13", "Electronics"),
        new Product(102, "Samsung Galaxy S21", "Electronics"),
        new Product(103, "Sony Headphones", "Accessories"),
        new Product(104, "Apple Watch", "Wearables")
    );

    public static List<Product> linearSearch(Product[] products, String term) {
    List<Product> results = new ArrayList<>();
    for (Product p : products) {
        if (p.productName.toLowerCase().contains(term.toLowerCase())) {
            results.add(p);
        }
    }
    return results;
}

    public static Product binarySearch(Product[] products, String target) {
    int left = 0, right = products.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        int cmp = products[mid].productName.compareToIgnoreCase(target);
        if (cmp == 0) return products[mid];
        else if (cmp < 0) left = mid + 1;
        else right = mid - 1;
    }
    return null;
}


public static void main(String[] args) {
    Product[] products = {
        new Product(101, "Apple iPhone 13", "Electronics"),
        new Product(102, "Samsung Galaxy S21", "Electronics"),
        new Product(103, "Sony Headphones", "Accessories"),
        new Product(104, "Apple Watch", "Wearables")
    };

    Scanner scanner = new Scanner(System.in);
    System.out.println("Search Type:\n1. Linear \n2. Binary ");
    int choice = scanner.nextInt(); scanner.nextLine();

    System.out.print("Enter product name to search: ");
    String query = scanner.nextLine();

    if (choice == 1) {
        List<Product> results = linearSearch(products, query);
        if (results.isEmpty()) System.out.println("No match found.");
        else for (Product p : results) System.out.println(p.productName + " - " + p.category);
    } else {
        Arrays.sort(products); // binary search requires sorted array
        Product result = binarySearch(products, query);
        if (result == null) System.out.println("No match found.");
        else System.out.println(result.productName + " - " + result.category);
    }

    scanner.close();
}

}
