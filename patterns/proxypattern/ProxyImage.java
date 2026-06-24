package proxypattern;

public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage; // cached reference

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
