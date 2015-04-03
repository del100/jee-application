package ie.ait.msc.discount.store.retailer.rest;

import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;
import ie.ait.msc.discount.store.retailer.ejb.RetailerServiceLocal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class RetailerRestServiceImpl implements RetailerRestService {

    @Inject
    RetailerServiceLocal retailerService;

    @Override
    public Response createAccount(RetailerDto retailerDto) {
        return Response.ok().build();
    }

    @Override
    public Response getTest() {
        final String test = "worked";
        return Response.ok().entity(test).build();
    }

    @Override
    public Response getAllOffers(@PathParam("username") String username) {

        List<OfferDto> offers = new ArrayList<OfferDto>();

        try {
            offers = retailerService.getAllOffers(username);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unable to retrieve any Offers!\n\n").build();
        }

        return Response.status(Response.Status.OK).entity(offers).build();
    }
}
