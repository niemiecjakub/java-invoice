package pl.edu.agh.mwo.invoice;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;

import java.math.BigDecimal;

public class InvoicePrinterTest {
    private Invoice invoice;
    private InvoicePrinter invoicePrinter;

    @Before
    public void createEmptyInvoiceForTheTest() {

        invoice = new Invoice();
        invoice.addProduct(new TaxFreeProduct("Chleb", new BigDecimal("5")), 2);
        invoice.addProduct(new DairyProduct("Chedar", new BigDecimal("10")), 3);
        invoice.addProduct(new OtherProduct("Pinezka", new BigDecimal("0.01")), 4);
        invoicePrinter = new InvoicePrinter(invoice);
    }

    @Test
    public void testInvoicePrintHeader(){
        String invoiceHeader = invoicePrinter.print().split(System.lineSeparator())[0];
        Assert.assertThat("Numer faktury: " + invoice.getNumber(), Matchers.comparesEqualTo(invoiceHeader));
    }

    @Test
    public void testInvoicePrintFooter(){
        String[] lines = invoicePrinter.print().split(System.lineSeparator());
        String footer = lines[lines.length - 1];
        Assert.assertThat("Liczba pozycji: " + invoice.countProducts(), Matchers.comparesEqualTo(footer));
    }

    @Test
    public void testInvoicePrintProduct(){
        String print = invoicePrinter.print();
        System.out.println(print);
    }

}
