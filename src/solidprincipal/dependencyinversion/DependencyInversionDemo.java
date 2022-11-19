package solidprincipal.dependencyinversion;

/* Dependency Inversion principal tells that High Level model should not depend on concrete classes
    It should always depend on Abstraction like Abstract classes or Interfaces
*/

interface Product
{
    public void getReviews();
    public void seeSamples();
}

class Book1 implements Product{

    @Override
    public void getReviews() {
        System.out.println("Review of Book");
    }

    @Override
    public void seeSamples() {
        System.out.println("Reading samples of Samples");
    }
}

class DVD1 implements Product
{
    @Override
    public void getReviews() {
        System.out.println("Review of DVD ");
    }

    @Override
    public void seeSamples() {
        System.out.println("Reading samples of DVD");
    }
}

class Shelf1
{
    private Product product;

    public Shelf1(Product product)
    {
        this.product = product;
    }

    public void addProductToShlef()
    {
        System.out.println("Added:"+product.getClass());
    }
}
public class DependencyInversionDemo {
    public static void main(String[] args) {

    Shelf1 shelf1 = new Shelf1(new Book1());
    shelf1.addProductToShlef();

    Shelf1 shelf2 = new Shelf1(new DVD1());
    shelf2.addProductToShlef();

    }
}
