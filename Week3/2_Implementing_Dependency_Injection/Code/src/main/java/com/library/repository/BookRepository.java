package com.library.repository;

public class BookRepository {
    private static int count = 0;

    public void saveBook(String bookName) {
        count++;
        System.out.println("Book saved: " + bookName);
    }

    public int getBookCount() {
        return count;
    }
}
