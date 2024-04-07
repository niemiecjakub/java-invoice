package pl.edu.agh.mwo.invoice;

public class InvoiceCounter {
    public static Integer getInvoiceCount() {
        return invoiceCount;
    }

    public static void incrementInvoiceCount() {
        invoiceCount++;
    }

    public static Integer invoiceCount = 1;

}
