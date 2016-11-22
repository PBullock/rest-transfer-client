package bankTransfer.resources;

import bankTransfer.bankService.UserService;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class LoginResource extends JerseyClient
{
    @Path("/auth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth()
    {
        UserService userService = new UserService("test_user","customer");
        return Response.ok(userService).build();
    }


    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test()
    {
        UserService userService = new UserService("test1","test2");
        return Response.ok(userService).build();
    }
}
