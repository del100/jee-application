package ie.ait.msc.discount.store.retailer.rest;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create/account")
    public Response createAccount(RetailerDto retailerDto);

    @GET
    @Produces({ "application/json" })
    @Path("test")
    public Response getTest();

    /**
     * This method allows users to retrieve any offers they have in the database.
     *
     * @return JSON array containing any offers for this user in the database.
     */
    @GET()
    @Produces({ "application/json" })
    @Path("AllOffers/{username}")
    public Response getAllOffers(@PathParam("username") String username);
}
