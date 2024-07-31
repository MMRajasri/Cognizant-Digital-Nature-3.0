public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // The image will be loaded from the server and displayed
        image1.display();

        // The image will be displayed from the cache
        image1.display();

        // The image will be loaded from the server and displayed
        image2.display();
    }
}
