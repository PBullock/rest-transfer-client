package bankTransfer.resources;

import bankTransfer.bankService.TransferService;
import bankTransfer.bankService.UserService;
import org.jboss.logging.Param;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserTransferResource {

    @Path("/transfer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTransferTransaction(@QueryParam("user_id") String user_id)
    {

        // decide what type of transfer
        // create transfer service request
        // wait for transfer service response
        // send ok/not ok response
        return Response.ok(new TransferService()).build();
    }

    @Path("/transfer")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response editUserAccount() {
        return Response.ok(new TransferService()).build();
    }

    @Path("/transfer")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserAccount() {

        //@QueryParam transfer_id
        // delete transfer using transfer id
        //request sent to transfer microservice

        return Response.ok(new TransferService()).build();
    }

}
