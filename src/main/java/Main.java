import pl.edu.agh.mwo.invoice.Invoice;
import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Product p1 = new DairyProduct("spodnie", new BigDecimal(100));
        Invoice invoice = new Invoice();
        invoice.addProduct(p1, 10);

        String list = invoice.getProductList();
        System.out.println(list);
    }

}