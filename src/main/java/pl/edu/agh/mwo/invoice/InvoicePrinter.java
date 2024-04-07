package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.Product;

public class InvoicePrinter {
    public Invoice invoice;
    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }
    public String header(){
        return "Numer faktury: " + invoice.getNumber() + System.lineSeparator();
    }

    private String footer(){
        return "Liczba pozycji: " + invoice.countProducts();
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        sb.append(header());
        for (Product product: invoice.getProducts()) {
            String productLine = "Produkt: " + product.getName() + "\tIlosc: " + 0 + "\tCena: " + product.getPriceWithTax() + System.lineSeparator();
            sb.append(productLine);
        }
        sb.append(footer());
        return sb.toString();
    }
}
