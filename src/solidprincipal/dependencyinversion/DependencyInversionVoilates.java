package solidprincipal.dependencyinversion;

import java.util.Map;

class Book
{
    private int id;
    private String title;

    public Book() {
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void seeReviews()
    {
        System.out.println("*****");
    }
    public void readSamples()
    {
        System.out.println("Reading samples");
    }
}

class Shelf
{
    //Here we are breaking Dependency Inversion principal because Our High level model i.e. Shelf is depends upons
    //Low Level model i.e. Book,When there is requirement where we have to add DVD's to Shelf then in that case we need to modify
    //the Shelf class which also breaks Open/Close Principal.

    private Book book;

    public void addBookToShelf(Book book)
    {
        System.out.println("Book added");
    }

}
public class DependencyInversionVoilates {
    public static void main(String[] args) {

    }
}
