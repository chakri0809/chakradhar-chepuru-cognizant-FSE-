package proxypattern;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.png");
        Image image2 = new ProxyImage("photo2.png");

        // First time: loads from remote server
        image1.display();
        System.out.println();

        // Second time: uses cached RealImage
        image1.display();
        System.out.println();

        // Another image: loads separately
        image2.display();
    }
}
