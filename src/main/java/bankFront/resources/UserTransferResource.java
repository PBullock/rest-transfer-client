package bankFront.resources;

import bankFront.bankService.TransferService;
import org.glassfish.jersey.client.JerseyClient;


import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserTransferResource extends JerseyClient{

    @Path("/transfer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTransferTransaction(@QueryParam("user_id") String user_id)
    {


        WebTarget transferTarget = this.target("http://164.132.201.211:54321");
        transferTarget.register(String.class);

        WebTarget transferResource = transferTarget.path("transfer");

        Invocation.Builder invocationBuilder =
                transferResource.request(MediaType.APPLICATION_JSON);

        Form transferForm = new Form();
        transferForm.param("glaeubiger", "12762549");
        transferForm.param("betrag",     "23.23");
        transferForm.param("schuldner",  "45698742");
        transferForm.param("anmerkung",  "test");

        Response response = invocationBuilder.post(Entity.form(transferForm));

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
