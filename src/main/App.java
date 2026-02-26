package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;
        
        while (!exit){
            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            String input = sc.nextLine();

            if (input.isEmpty()) {
                continue;
            }
                
                int i = Integer.parseInt(input);
                switch (i){
                    case 1:
                        System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                        int bookChoice = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Anna kirjan nimi:");
                        String bookName = sc.nextLine();

                        System.out.println("Anna kirjailijan nimi:");
                        String authorName = sc.nextLine();

                        System.out.println("Anna sivumäärä:");
                        int inputPages = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Anna kirjojen määrä:");
                        int inputCopies = sc.nextInt();
                        sc.nextLine();

                        Book newbook = null;
                        switch (bookChoice) {
                            case 1:
                                newbook = new FictionBook(bookName, authorName, inputPages, inputCopies);
                                break;
                            case 2:
                                newbook = new NonFictionBook(bookName, authorName, inputPages, inputCopies);
                                break;
                            default:
                                System.out.println("Virheellinen kirjatyyppi.");
                                break;
                        }
                        if (newbook != null) {
                            library.addBook(newbook);
                            System.out.println("Kirja lisätty kirjastoon!");
                        }
                        break;
                    case 2:
                        library.listBooks();
                        break;
                    case 3:
                        System.out.println("Anna lainattavan kirjan nimi:");
                        String borrowName = sc.nextLine();
                        boolean foundBorrowBook = false;
                        for (Book book : library.getBooks()){
                            if (book.getTitle().equals(borrowName)){
                                if (book instanceof Borrowable){
                                    Borrowable b = (Borrowable) book;
                                    b.borrow();
                                } else{
                                    System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                                }
                                foundBorrowBook = true;
                                break;
                            }
                        }
                        if (!foundBorrowBook){
                            System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                        }
                        break;        
                    case 4:
                        System.out.println("Anna palautettavan kirjan nimi:");
                        String returnName = sc.nextLine();
                        boolean foundReturnBook = false;
                        for (Book book : library.getBooks()){
                            if (book.getTitle().equals(returnName)){
                                if (book instanceof Borrowable){
                                    Borrowable b = (Borrowable) book;
                                    b.returnBook();
                                } else{
                                    System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                                }
                                foundReturnBook = true;
                                break;
                            }
                        }
                        if (!foundReturnBook){
                            System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                        }
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;    
                    default:
                        System.out.println("Tuntematon valinta.");
                        break;
            }    
        }
        sc.close();
    }
}
