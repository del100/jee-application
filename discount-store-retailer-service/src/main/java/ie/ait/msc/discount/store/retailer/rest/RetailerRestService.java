package ie.ait.msc.discount.store.retailer.rest;

import ie.ait.msc.discount.store.dto.OfferDto;
import ie.ait.msc.discount.store.dto.RetailerDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/retailer")
public interface RetailerRestService {

    /**
     * Simple method that allows us to test that the REST service is responding.
     */
    @GET
    @Produces({ "application/json" })
    @Path("test")
    public Response getTest();

    /**
     * Create a new Retailer account.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create/account")
    public Response createAccount(RetailerDto retailerDto);

    /**
     * Allows users to retrieve any offers they have in the database.
     */
    @GET()
    @Produces({ "application/json" })
    @Path("AllOffers/{username}")
    public Response getAllOffers(@PathParam("username") String username);

    /**
     * Allows retailers to add new offers to the database.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create/offer")
    Response createOffer(OfferDto offerDto, @PathParam("username") String username);
}
