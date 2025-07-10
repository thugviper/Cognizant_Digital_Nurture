package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter injection called");
        this.bookRepository = bookRepository;
    }

    public void registerBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
    public void getBookCount() {
        System.out.println("No.of books available:"+bookRepository.getBookCount());
    }


}
