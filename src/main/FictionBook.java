package main;

public class FictionBook extends Book implements Borrowable {
    private int borrowedCount;

    public FictionBook(String title, String author, int pages, int copies){
        super(title, author, pages, copies);
    }

    @Override
    public String categorize() {
        return "Fiktiokirja";
    }

    @Override
    public void borrow(){
        if (copies > 0){
            copies--;
            borrowedCount++;
            System.out.println("Kirja " + title + " on nyt lainattu.");
        } else { 
            System.out.println("Kirjaa " + title + " ei enään ole lainattavissa!");    
        }

    }

    @Override
    public void returnBook() {
        if (borrowedCount > 0){
            copies++;
            borrowedCount--;
            System.out.println("Kirja " + title + " on palautettu.");
        } else {
           System.out.println("Kirja " + title + " ei ole lainassa."); 
        }
    }
}
