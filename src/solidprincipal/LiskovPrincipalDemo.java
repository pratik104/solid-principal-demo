package solidprincipal;

import java.awt.print.Book;
/*
Here we seperated the getDeliverylocation() code in two diffrent classes to compatible with Liskov Principal
* */
class BookDelivery1
{
    private int id;
    private String title;

    public BookDelivery1(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public BookDelivery1() {
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

   // We have removed the getLocationDelivery() because its not compatible for both audiobook and BookHardCopy object
}

class OnlineDelivery extends BookDelivery1
{
    //Here we have created getOnlineDeliveryAppName() to get the app name for delivery.
    public String getOnlineDeliveryAppName()
    {
        return "KUKU FM";
    }
}

class OffLineDelivery extends BookDelivery1
{
    //Here we have seperated the offline delivery location.
    public String getLocationDelivery()
    {
        return "Pune";
    }
}

//Hard copy book extends OfflineDelivery and overrides getLocationDelivery()
class BookHardCopy1 extends OffLineDelivery
{
    @Override
    public String getLocationDelivery() {
        System.out.println(super.getLocationDelivery());
        return super.getLocationDelivery();
    }
}

//Audio book extends onlineDelivery and overides getOnlineDeliveryAppName()
class AudioBook1 extends OnlineDelivery
{
    @Override
    public String getOnlineDeliveryAppName() {
        System.out.println(super.getOnlineDeliveryAppName());
        return super.getOnlineDeliveryAppName();
    }
}


public class LiskovPrincipalDemo {
    public static void main(String[] args) {

        OffLineDelivery offLineDelivery = new BookHardCopy1();
        offLineDelivery.getLocationDelivery();

        BookDelivery1 bookDelivery1 = offLineDelivery;

        OnlineDelivery onlineDelivery = new AudioBook1();
        onlineDelivery.getOnlineDeliveryAppName();

        BookDelivery1 bookDelivery2 = onlineDelivery;

    }
}
