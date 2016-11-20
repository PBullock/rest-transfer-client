package bankTransfer.resources;

import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginResource extends JerseyClient
{
    @Path("/auth")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String auth()
    {
        return "test1";
    }
}
