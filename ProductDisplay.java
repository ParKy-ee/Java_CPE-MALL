import java.util.Scanner;

public class ProductDisplay {

    Scanner sc = new Scanner(System.in);
    ProductManage productManage;

    public ProductDisplay(ProductManage productManage) {
        this.productManage = productManage;
    }

    public void addProduct() {

        System.out.println("--------------หน้าเพิ่มสินค้า-----------------");
        System.out.print("ชื่อสินค้า: ");
        String name = sc.nextLine();

        System.out.print("ราคา: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("สต็อก: ");
        int stock = Integer.parseInt(sc.nextLine());

        Product product = new Product(
                String.valueOf(productManage.getProducts().size()),
                name,
                price,
                stock);

        productManage.addProduct(product);

        System.out.println("------------------------------------------------");
        System.out.println("เพิ่มสินค้าสำเร็จ");
        System.out.println("------------------------------------------------");
    }

    public void getProduct() {

        System.out.println("--------------หน้าแสดงสินค้า-----------------");

        for (Product product : productManage.getProducts()) {

            System.out.println("รหัสสินค้า: " + product.getId());
            System.out.println("ชื่อสินค้า: " + product.getName());
            System.out.println("ราคา: " + product.getPrice());
            System.out.println("สต็อก: " + product.getStock());
            System.out.println("------------------------------------------------");

        }
    }

    public void updateProduct() {

        System.out.println("--------------หน้าแก้ไขสินค้า-----------------");

        System.out.print("รหัสสินค้า: ");
        String id = sc.nextLine();

        Product product = productManage.getProduct(id);

        if (product == null) {
            System.out.println("ไม่พบสินค้า");
            return;
        }

        System.out.print("ชื่อสินค้า: ");
        String name = sc.nextLine();

        System.out.print("ราคา: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("สต็อก: ");
        int stock = Integer.parseInt(sc.nextLine());

        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        productManage.updateProduct(product);

        System.out.println("------------------------------------------------");
        System.out.println("แก้ไขสินค้าสำเร็จ");
        System.out.println("------------------------------------------------");
    }

    public void removeProduct() {

        System.out.println("--------------หน้าลบสินค้า-----------------");

        System.out.print("รหัสสินค้า: ");
        String id = sc.nextLine();

        Product product = productManage.getProduct(id);

        if (product == null) {
            System.out.println("ไม่พบสินค้า");
            return;
        }

        productManage.removeProduct(product);

        System.out.println("------------------------------------------------");
        System.out.println("ลบสินค้าสำเร็จ");
        System.out.println("------------------------------------------------");
    }

}