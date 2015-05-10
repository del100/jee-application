package ie.ait.msc.discount.store.retailer.rest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;
import ie.ait.msc.discount.store.retailer.ejb.RetailerServiceLocal;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RetailerRestServiceTest {

    private String mockUsername = "user";

    @InjectMocks
    private RetailerRestServiceImpl retailerRestService;

    @Mock
    private RetailerServiceLocal mockRetailerService;
    @Mock
    private OfferDto mockOfferDto;
    @Mock
    private RetailerDto mockRetailer;

    private List<OfferDto> offers = new ArrayList<OfferDto>();

    @Before
    public void setup() {
        retailerRestService = new RetailerRestServiceImpl();
        offers.add(mockOfferDto);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllOffers_success() {
        // setup
        when(mockRetailerService.getAllOffers(mockUsername)).thenReturn(offers);

        // execute
        Response response = retailerRestService.getAllOffers(mockUsername);

        // verify
        assertTrue(response.getStatus() == 200);
        assertTrue(response.getEntity().equals(offers));
    }

    @Test
    public void createAccount_success() {
        // setup
        Mockito.doNothing().when(mockRetailerService).createAccount(mockRetailer);

        // execute
        Response response = retailerRestService.createAccount(mockRetailer);

        // verify
        assertTrue(response.getStatus() == 200);
    }

    @Test
    public void createOffer_success() {

        // setup
        Mockito.doNothing().when(mockRetailerService).addNewOffer(mockOfferDto, mockUsername);
        when(mockOfferDto.getUrl()).thenReturn("url");
        when(mockOfferDto.getDescription()).thenReturn("description");

        // execute
        Response response = retailerRestService.createOffer(mockOfferDto, mockUsername);

        // verify
        assertTrue(response.getStatus() == 200);
    }
}