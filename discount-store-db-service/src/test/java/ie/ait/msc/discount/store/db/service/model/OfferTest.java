package ie.ait.msc.discount.store.db.service.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OfferTest {

    private static final String DESCRIPTION = "test";
    private static final String URL = "http://www.test";
    private static final Long ID = new Long("10");

    private Offer offer;

    @Before
    public void setup() {
        OfferCategory category = new OfferCategory();
        offer = new Offer();
        offer.setId(ID);
        offer.setDescription(DESCRIPTION);
        offer.setUrl(URL);
        offer.setCategory(category);
    }

    @Test
    public void getId() {
        assertTrue(offer.getId() == ID);
    }

    @Test
    public void getDescription_success() {
        assertTrue(offer.getDescription().equals(DESCRIPTION));
    }

    @Test
    public void getUrl_success() {
        assertTrue(offer.getUrl().equals(URL));
    }

    @Test
    public void getCategory_success() {
        assertTrue(offer.getCategory() != null);
    }

    @Test
    public void toString_success() {
        assertTrue(offer.toString().contains(URL));
    }

    @Test
    public void equals_success() {
        Offer anotherOffer = new Offer();
        anotherOffer.setUrl(URL);
        assertTrue(offer.equals(anotherOffer));
    }

    @Test
    public void hashCode_success() {
        assertTrue(offer.hashCode() != 0);
    }
}
