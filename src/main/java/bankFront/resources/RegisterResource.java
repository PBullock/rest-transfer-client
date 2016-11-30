package bankFront.resources;

import bankFront.bankService.RegisterService;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("register")
public class RegisterResource extends JerseyClient {

    @Path("/user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
            @FormParam("name") String name,
            @FormParam("first_name") String first_name) {

        //send request to register micro service
        //

        RegisterService registerService = new RegisterService(name, first_name);
        return Response.ok(registerService).build();
    }
}
