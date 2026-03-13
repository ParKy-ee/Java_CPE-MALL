import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    Scanner sc = new Scanner(System.in);

    List<Product> products = new ArrayList<>();
    ProductManage productManage = new ProductManage(products);

    List<User> users = new ArrayList<>();
    Auth auth = new Auth(users);

    ProductDisplay productDisplay = new ProductDisplay(productManage);
    CartDisplay cartDisplay = new CartDisplay(productManage);
    ReceiptManage receiptManage = new ReceiptManage();

    public void showMenu() {
        while (true) {
            System.out.println("--------------หน้าลงชื่อเข้าใช้-----------------");
            System.out.println("1. ลงชื่อเข้าใช้");
            System.out.println("2. สมัครสมาชิก");
            System.out.println("3. ออก");
            System.out.println("------------------------------------------------");
            System.out.print("เลือก: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("ไม่ถูกต้อง");
            }
        }

    }

    public void login() {
        int attempt = 0;

        while (attempt < 3) {
            System.out.println("--------------หน้าลงชื่อเข้าใช้-----------------");
            System.out.print("ชื่อผู้ใช้: ");
            String username = sc.nextLine();

            System.out.print("รหัสผ่าน: ");
            String password = sc.nextLine();

            User user = auth.login(username, password);

            if (user != null) {

                System.out.println("------------------------------------------------");
                System.out.println("เข้าสู่ระบบสำเร็จ");
                System.out.println("------------------------------------------------");

                if (user.getRole().equals("Admin")) {
                    showAdminMenu();
                } else {
                    showUserMenu();
                }

                break;

            } else {
                System.out.println("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
                attempt++;
                continue;
            }
        }
    }

    public void registerAdmin() {

        System.out.println("--------------หน้าลงทะเบียนผู้ดูแลระบบ-----------------");

        System.out.print("ชื่อผู้ดูแลระบบ: ");
        String username = sc.nextLine();

        System.out.print("รหัสผ่าน: ");
        String password = sc.nextLine();

        User user = auth.register(username, password);

        if (user == null) {
            System.out.println("ชื่อผู้ใช้ซ้ำ");
            return;
        }

        System.out.println("สมัครสมาชิกสำเร็จ");
        showMenu();
    }

    public void register() {

        while (true) {

            System.out.println("--------------หน้าลงทะเบียนผู้ใช้-----------------");

            System.out.print("ชื่อผู้ใช้: ");
            String username = sc.nextLine();

            System.out.print("รหัสผ่าน: ");
            String password = sc.nextLine();

            User user = auth.register(username, password);

            if (user == null) {
                System.out.println("ชื่อผู้ใช้ซ้ำ");
                continue;
            }

            System.out.println("------------------------------------------------");
            System.out.println("สมัครสมาชิกสำเร็จ");
            System.out.println("------------------------------------------------");

            break;
        }
    }

    public void showAdminMenu() {

        while (true) {

            System.out.println("--------------หน้าผู้ดูแลระบบ-----------------");
            System.out.println("1. เพิ่มสินค้า");
            System.out.println("2. ลบสินค้า");
            System.out.println("3. แก้ไขสินค้า");
            System.out.println("4. แสดงสินค้า");
            System.out.println("5. ลบสินค้า");
            System.out.println("6. แสดงยอดขาย");
            System.out.println("7. ออก");
            System.out.println("------------------------------------------------");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    productDisplay.addProduct();
                    break;

                case 2:
                    productDisplay.removeProduct();
                    break;

                case 3:
                    productDisplay.updateProduct();
                    break;

                case 4:
                    productDisplay.getProduct();
                    break;

                case 5:
                    productDisplay.removeProduct();
                    break;

                case 6:
                    showSales();
                    break;

                case 7:
                    return;

                default:
                    System.out.println("ไม่ถูกต้อง");
            }
        }

    }

    public void showUserMenu() {
        User currentUser = auth.getUser();

        while (true) {

            System.out.println("--------------หน้าผู้ใช้-----------------");
            System.out.println("1. แสดงสินค้า");
            System.out.println("2. เพิ่มสินค้าลงตะกร้า");
            System.out.println("3. แสดงสินค้าในตะกร้า");
            System.out.println("4. ลบสินค้าออกจากตะกร้า");
            System.out.println("5. เติมเงิน");
            System.out.println("6. ชำระสินค้า");
            System.out.println("7. ออก");
            System.out.println('\n');
            if (currentUser != null) {
                System.out.println("เงินในกระเป๋า: " + currentUser.getWallet().getBalance());
            }
            System.out.println("ยอดรวม: " + cartDisplay.getTotalPrice());
            System.out.println("------------------------------------------------");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    productDisplay.getProduct();
                    break;

                case 2:
                    cartDisplay.addProductOnCart();
                    break;
                case 3:
                    cartDisplay.showProductsOnCart();
                    break;
                case 4:
                    cartDisplay.removeProductOnCart();
                    break;
                case 5:
                    addBalance();
                    break;
                case 6:
                    pay();
                    break;

                case 7:
                    return;
                default:
                    System.out.println("ไม่ถูกต้อง");
            }
        }
    }

    public void addBalance() {
        System.out.println("--------------หน้าเติมเงิน-----------------");
        System.out.print("จำนวนเงิน: ");
        int balance = sc.nextInt();
        User user = auth.getUser();
        user.getWallet().addBalance(balance);
        System.out.println("เติมเงินสำเร็จ");
        System.out.println("------------------------------------------------");

    }

    public void pay() {
        User user = auth.getUser();
        double balance = user.getWallet().getBalance();
        double totalPrice = cartDisplay.getTotalPrice();
        if (balance < totalPrice) {
            System.out.println("เงินไม่เพียงพอ");
            return;
        }

        List<CartItem> itemsCopy = new ArrayList<>(cartDisplay.getCart().getCartItems());
        Cart cartCopy = new Cart(itemsCopy, user);

        Receipt receipt = new Receipt(totalPrice, user, cartCopy);
        receiptManage.addReceipt(receipt);

        user.getWallet().removeBalance(totalPrice);
        cartDisplay.getCart().getCartItems().clear();
        System.out.println("ชำระเงินสำเร็จ");
    }

    public void showSales() {
        double totalSales = 0;
        for (Receipt receipt : receiptManage.getReceipts()) {
            totalSales += receipt.getTotal();
        }
        System.out.print("ยอดขายทั้งหมด : ");
        System.out.println(totalSales + " บาท");
        System.out.println("จำนวนการขายทั้งหมด : " + receiptManage.getReceipts().size() + " รายการ");
        for (Receipt receipt : receiptManage.getReceipts()) {

            System.out.println("เลขที่ใบเสร็จ: " + receipt.getId());
            System.out.println("ลูกค้า: " + receipt.getUser().getUsername());
            System.out.println("ยอดรวม: " + receipt.getTotal());

            System.out.println("รายการสินค้า:");

            for (CartItem item : receipt.getCart().getCartItems()) {

                System.out.println(
                        item.getProduct().getName()
                                + " x " + item.getQuantity()
                                + " = " + item.getProduct().getPrice() * item.getQuantity());
            }

            System.out.println("--------------------------------");
        }

    }
}
