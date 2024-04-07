package pl.edu.agh.mwo.invoice;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceCountTest {
    @Test
    public void testNumberIncrement(){
        int initialState = 1;
        int endValue = 4;
        for (int i=initialState ; i<endValue;i++){
            InvoiceCounter.incrementInvoiceCount();
        }
        Assert.assertThat(endValue, Matchers.comparesEqualTo(InvoiceCounter.getInvoiceCount()));
    }
}
