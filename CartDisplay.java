import java.util.ArrayList;
import java.util.Scanner;

public class CartDisplay {

    Scanner sc = new Scanner(System.in);
    Cart cart = new Cart(new ArrayList<>(), null);
    ProductManage productManage;

    public CartDisplay(ProductManage productManage) {
        this.productManage = productManage;
    }

    public void addProductOnCart() {

        System.out.println("--------------หน้าเพิ่มสินค้าลงตะกร้า-----------------");
        System.out.print("รหัสสินค้า: ");
        String id = sc.nextLine();
        Product product = productManage.getProduct(id);
        if (product == null) {
            System.out.println("ไม่พบสินค้า");
            return;
        }

        cart.addProductOnCart(product);
        System.out.println("------------------------------------------------");
        System.out.println("เพิ่มสินค้าลงตะกร้าสำเร็จ");
        System.out.println("------------------------------------------------");

    }

    public void removeProductOnCart() {

        System.out.println("--------------หน้าลบสินค้าออกจากตะกร้า-----------------");
        System.out.print("รหัสสินค้า: ");
        String id = sc.nextLine();
        Product product = productManage.getProduct(id);
        if (product == null) {
            System.out.println("ไม่พบสินค้า");
            return;
        }
        cart.removeProductOnCart(id);
        System.out.println("------------------------------------------------");
        System.out.println("ลบสินค้าออกจากตะกร้าสำเร็จ");
        System.out.println("------------------------------------------------");

    }

    public double getTotalPrice() {
        return cart.getTotalPrice();
    }

    public Cart getCart() {
        return cart;
    }

    public void showProductsOnCart() {

        int totalPrice = 0;

        if (cart.getCartItems().isEmpty()) {
            System.out.println("ไม่มีสินค้าในตะกร้า");
            return;
        }

        System.out.println("--------------สินค้าในตะกร้า-----------------");

        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            System.out.println("รหัสสินค้า: " + product.getId());
            System.out.println("ชื่อสินค้า: " + product.getName());
            System.out.println("ราคา: " + product.getPrice());
            System.out.println("จำนวน: " + item.getQuantity());
            System.out.println("------------------------------");
            totalPrice += product.getPrice() * item.getQuantity();

        }

        System.out.println("ราคารวม: " + totalPrice);
        System.out.println("------------------------------------------------");
    }

}
