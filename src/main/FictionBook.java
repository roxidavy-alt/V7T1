package main;

public class FictionBook extends Book{
    public FictionBook(String title, String author, int pages, int copies){
        super(title, author, pages, copies);
    }

    @Override
    public String categorize() {
        return "Fiktiokirja";
    }
}
