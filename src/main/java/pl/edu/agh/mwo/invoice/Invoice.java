package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private static int invoiceCount = 0;
    private Integer number;
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public Invoice() {
        this.number = ++invoiceCount;
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public Integer getNumber() {
        return number;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getProductList() {
        String productList = "";
        productList += "Nr: " + number + "\n";
        int totalProducts = 0;
        for (Product product: products.keySet()) {
            String name = product.getName();
            Integer quantity = products.get(product);
            BigDecimal price = product.getPrice();

            productList += name + " - " + quantity + " szt - " + price + " PLN \n";
            totalProducts += quantity;
        }
        productList += "Lista pozycji: " + totalProducts;
        return productList;
    }
}
