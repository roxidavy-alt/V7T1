package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    
    public Library(){
        books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void listBooks(){
        int sum = 0;
        for (Book book: books){            
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());
            sum += book.getCopies();
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + sum);
    }
}
