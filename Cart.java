import java.util.List;

public class Cart {

    List<CartItem> cartItems;
    User currentUser;

    public Cart(List<CartItem> cartItems, User currentUser) {
        this.cartItems = cartItems;
        this.currentUser = currentUser;
    }

    public void addProductOnCart(Product product) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        cartItems.add(new CartItem(product, 1));
    }

    public void removeProductOnCart(String id) {

        CartItem itemToRemove = null;
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(id)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            cartItems.remove(itemToRemove);
            System.out.println("ลบสินค้าออกจากตะกร้าแล้ว");
        } else {
            System.out.println("ไม่พบสินค้าในตะกร้า");
        }
    }

    public void updateProductOnCart(Product product) {

        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setProduct(product);
                break;
            }
        }
    }

    public Product getProductOnCart(String id) {

        for (CartItem cartItem : cartItems) {

            if (cartItem.getProduct().getId().equals(id)) {
                return cartItem.getProduct();
            }

        }

        return null;
    }

    public void showProductsOnCart() {

        double totalPrice = 0;

        if (cartItems.isEmpty()) {
            System.out.println("ไม่มีสินค้าในตะกร้า");
            return;
        }

        System.out.println("--------------สินค้าในตะกร้า-----------------");

        for (CartItem item : cartItems) {
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

}