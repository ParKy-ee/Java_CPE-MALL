public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        // Add sample products directly to the display's product list
        display.products.add(new Product("1", "Iphone 15", 35000, 10));
        display.products.add(new Product("2", "Samsung S24", 32000, 8));
        display.products.add(new Product("3", "Ipad Pro", 42000, 5));

        display.registerAdmin();
    }
}