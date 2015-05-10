package ie.ait.msc.discount.store.retailer.rest;

import ie.ait.msc.discount.store.db.service.api.DiscountStoreDbException;
import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;
import ie.ait.msc.discount.store.retailer.ejb.RetailerServiceLocal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetailerRestServiceImpl implements RetailerRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetailerRestServiceImpl.class);

    @Inject
    RetailerServiceLocal retailerService;

    @Override
    public Response createAccount(RetailerDto retailerDto) {
        return Response.ok().build();
    }

    @Override
    public Response getTest() {
        LOGGER.info("This is just a test!");
        return Response.ok().entity("hello from server").build();
    }

    @Override
    public Response getAllOffers(@PathParam("username") String username) {

        LOGGER.info("Received request to fetch all offers for user [{}]", username);

        List<OfferDto> offers = new ArrayList<OfferDto>();

        try {
            offers = retailerService.getAllOffers(username);
        } catch (DiscountStoreDbException e) {
            LOGGER.error("Error occurred while trying to retrieve offers from the db [{}], [{}]", e.getMessage(), e.getStackTrace());
            handleException(e, Status.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred", e.getMessage(), e.getStackTrace());
            handleException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }

        return Response.status(Status.OK).entity(offers).build();
    }

    @Override
    public Response createOffer(OfferDto offerDto, @PathParam("username") String username) {

        LOGGER.info("Received request to create new offer from user [{}]", username);
        try {
            retailerService.addNewOffer(offerDto, username);
        } catch (DiscountStoreDbException e) {
            LOGGER.error("Error occurred while trying to add offer to the db [{}], [{}]", e.getMessage(), e.getStackTrace());
            handleException(e, Status.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred", e.getMessage(), e.getStackTrace());
            handleException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
        return Response.status(Response.Status.OK).build();
    }

    private void handleException(Exception e, Status status) {
        Response response = Response.status(status).entity(e.getMessage()).build();
        throw new WebApplicationException(response);
    }
}
