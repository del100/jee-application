package ie.ait.msc.discount.store.db.service.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OfferCategoryTest {

    private static final String CATEGORY = "test";
    private OfferCategory offerCategory;

    @Before
    public void setup() {
        offerCategory = new OfferCategory();
        offerCategory.setDescription(CATEGORY);
    }

    @Test
    public void getDescription_success() {
        assertTrue(offerCategory.getDescription().equals(CATEGORY));
    }

    @Test
    public void toString_success() {
        assertTrue(offerCategory.toString().equals(CATEGORY));
    }

    @Test
    public void equals_success() {
        OfferCategory anotherOfferCategory = new OfferCategory();
        anotherOfferCategory.setDescription(CATEGORY);
        assertTrue(offerCategory.equals(anotherOfferCategory));
    }

    @Test
    public void hashCode_success() {
        assertTrue(offerCategory.hashCode() > 0);
    }
}
