# E-commerce Product Search 

## Description

This Java program lets users search for products using:
- **Linear Search** – allows partial, flexible matches (e.g., "apple")
- **Binary Search** – fast, but requires exact full name (e.g., "Apple Watch")

Both methods are combined in a single file (`Searches.java`) with a menu-driven console interface.

---

## Search Methods

### 1. Linear Search
- Scans every item in the list.
- Finds all products where the name **contains** the search term.
- Good for flexible searching.
- Slow (O(n))

### 2. Binary Search
- First sorts the product list alphabetically.
- Then performs a fast **divide-and-conquer** search.
- Good for exact matches in large datasets.
- Fails if you search with partial words.
- Fast (O(log n))
