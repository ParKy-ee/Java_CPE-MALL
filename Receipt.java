public class Receipt {

    private String id;
    private double total;
    private User user;
    private Cart cart;

    public Receipt(String id, double total, User user, Cart cart) {
        this.id = id;
        this.total = total;
        this.user = user;
        this.cart = cart;
    }

    public Receipt(double total, User user, Cart cart) {
        this.id = java.util.UUID.randomUUID().toString();
        this.total = total;
        this.user = user;
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
