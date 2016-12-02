package bankFront.resources;

import bankFront.bankService.TransferService;
import org.glassfish.jersey.Beta;
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
    public Response createTransferTransaction(
            @FormParam("kontonummer") String glaeubiger,
            @FormParam("Betrag") String Betrag,
            @FormParam("kommentar") String Kommentar
    )
    {


        WebTarget transferTarget = this.target("http://164.132.201.211:54321");
        transferTarget.register(String.class);

        WebTarget transferResource = transferTarget.path("transfer" ); // ?glaeubiger=" + glaeubiger + "&betrag=" + Betrag +"&schuldner=12762549&Anmerkung="+Kommentar

        transferResource = transferResource.queryParam("glaeubiger", glaeubiger);
        transferResource = transferResource.queryParam("betrag", Betrag);
        transferResource = transferResource.queryParam("schuldner",  "12762549");
        transferResource = transferResource.queryParam("Anmerkung",  Kommentar);

        Invocation.Builder invocationBuilder =
                transferResource.request(MediaType.APPLICATION_JSON);

        Form transferForm = new Form();


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
