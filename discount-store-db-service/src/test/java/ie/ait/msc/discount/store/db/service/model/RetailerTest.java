package ie.ait.msc.discount.store.db.service.model;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RetailerTest {

    private static final String VAT_NUMBER = "123456";
    private static final Long ID = new Long("10");
    private static final String NAME = "retailer1";

    private Retailer retailer;

    @Before
    public void setup() {
        Set<Offer> offers = new HashSet<Offer>();
        Offer offer = new Offer();
        offers.add(offer);

        retailer = new Retailer();
        retailer.setId(ID);
        retailer.setVatNumber(VAT_NUMBER);
        retailer.setName(NAME);
        retailer.setOffers(offers);
    }

    @Test
    public void getId() {
        assertTrue(retailer.getId() == ID);
    }

    @Test
    public void getVatNumber_success() {
        assertTrue(retailer.getVatNumber().equals(VAT_NUMBER));
    }

    @Test
    public void getName_success() {
        assertTrue(retailer.getName().equals(NAME));
    }

    @Test
    public void getOffers_success() {
        assertTrue(retailer.getOffers().size() == 1);
    }

    @Test
    public void toString_success() {
        assertTrue(retailer.toString().contains(VAT_NUMBER));
    }

    @Test
    public void equals_success() {
        Retailer anotherRetailer = new Retailer();
        anotherRetailer.setVatNumber(VAT_NUMBER);
        assertTrue(retailer.equals(anotherRetailer));
    }

    @Test
    public void hashCode_success() {
        assertTrue(retailer.hashCode() != 0);
    }
}
