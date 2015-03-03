package ie.ait.msc.discount.store.retailer.rest;

import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;
import ie.ait.msc.discount.store.retailer.ejb.RetailerServiceLocal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/retailer")
public class RetailerRestService {

    @Inject
    RetailerServiceLocal retailerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create/account")
    public Response createAccount(RetailerDto retailerDto) {
        return Response.ok().build();
    }

    @GET
    @Produces({ "application/json" })
    @Path("test")
    public Response getTest() {
        final String test = "worked";
        return Response.ok().entity(test).build();
    }

    /**
     * This method allows users to retrieve any offers they have in the database.
     *
     * @return JSON array containing any offers for this user in the database.
     */
    @GET()
    @Produces({ "application/json" })
    @Path("AllOffers/{username}")
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
