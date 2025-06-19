# E-commerce Product Search (Java)

## Description

This Java program lets users search for products using:
- **Linear Search** – allows partial, flexible matches (e.g., "apple"). It scans every item in the list, hence takes o(n) time. Hence, is Good for flexible searching.

- **Binary Search** – fast but requires exact full name (e.g., "Apple Watch"). It first sorts the product list alphabetically (o(nlog(n))), then performs a fast **divide-and-conquer** search (o(log(n)). Hence, is good for exact matches in large datasets.

Both methods are combined in a single file (`Search.java`) with a menu-driven console interface.





