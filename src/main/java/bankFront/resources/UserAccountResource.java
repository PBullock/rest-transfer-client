package bankFront.resources;

import bankFront.bankService.UserService;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserAccountResource extends JerseyClient
{
    @Path("/account")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserAccount(
            @QueryParam("benutzer") Integer Benutzer
        )
    {
        // load user details, build json, return ok if user exists - error if no user found


        return Response.ok(new UserService("test1", "test2")).build();
    }

    @Path("/account")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUserAccount() {
        //create account
        //send request to request service with account details

        return Response.ok(new UserService("test1", "test2")).build();
    }

    @Path("/account")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response editUserAccount()
    {
        return Response.ok(new UserService("test1", "test2")).build();
    }

    @Path("/account")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserAccount() {
        return Response.ok(new UserService("test1", "test2")).build();
    }
}
