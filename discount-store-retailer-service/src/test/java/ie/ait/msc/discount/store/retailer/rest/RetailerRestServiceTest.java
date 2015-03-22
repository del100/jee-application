package ie.ait.msc.discount.store.retailer.rest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.retailer.ejb.RetailerServiceLocal;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RetailerRestServiceTest {

    @InjectMocks
    private RetailerRestService retailerRestService;

    @Mock
    RetailerServiceLocal retailerService;

    @Before
    public void setup() {
        retailerRestService = new RetailerRestService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllOffers_success() {
        List<OfferDto> offers = new ArrayList<OfferDto>();
        OfferDto offer = new OfferDto();
        offers.add(offer);
        when(retailerService.getAllOffers("user")).thenReturn(offers);

        Response response = retailerRestService.getAllOffers("user");

        assertTrue(response.getStatus() == 200);
        assertTrue(response.getEntity().equals(offers));
    }
}