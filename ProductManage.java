import java.util.List;
import java.util.ArrayList;

public class ProductManage {

    private List<Product> products;

    public ProductManage() {
        this.products = new ArrayList<>();
    }

    public ProductManage(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product product) {
        products.set(products.indexOf(product), product);
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
