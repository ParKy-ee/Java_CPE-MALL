import java.util.List;
import java.util.ArrayList;

public class ReceiptManage {

    List<Receipt> receipts;

    public ReceiptManage() {
        this.receipts = new ArrayList<>();
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

}
