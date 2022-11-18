package solidprincipal;

class BookDelivery
{
    private int id;
    private String title;

    public BookDelivery(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public BookDelivery() {
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

    public String getLocationDelivery()
    {
        String loc = "";
        return loc;
    }
}

class BookHardCopy extends BookDelivery
{
    @Override
    public String getLocationDelivery() {
        return "Mumbai";
    }
}

class AudioBook extends BookDelivery
{
    @Override
    public String getLocationDelivery() {
        //Here we are voilating the Liskov principal as we can not provide physical locations to AudioBooks.
        //But for BookHardCopy books we can provide physical locations.
        //So her we could not replace BookDelivery super class with AudioBook Subclass
        return null;
    }
}
public class LiskovPrincipalVoilatesDemo {

    public static void main(String[] args) {

        BookDelivery bookDelivery1 = new BookHardCopy(); // We are not voilating liskov principal
        String loc1 = bookDelivery1.getLocationDelivery();
        System.out.println(loc1);

        BookDelivery bookDelivery2 = new AudioBook(); // We are voilating liskov principal
        String loc2 = bookDelivery2.getLocationDelivery();
        System.out.println(loc2);



    }
}
