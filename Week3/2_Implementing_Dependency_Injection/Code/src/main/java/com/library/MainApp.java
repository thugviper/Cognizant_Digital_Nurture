package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int x=1;
        while(x>0) {
            bookService.getBookCount();
            System.out.println("Enter book name to add:");
            String bookName = new java.util.Scanner(System.in).nextLine();
            bookService.registerBook(bookName);
            System.out.println("Book added successfully!");
            System.out.println("press 1 to add another book/press 0 to exit");
            x = new java.util.Scanner(System.in).nextInt();
        }

    }
}
