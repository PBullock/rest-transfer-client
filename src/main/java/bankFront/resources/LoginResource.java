package bankFront.resources;

import bankFront.bankService.UserService;
import bankFront.data.UserDataAccess;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class LoginResource extends JerseyClient
{
    @Path("/auth")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(
            @FormParam("email") String email,
            @FormParam("passwort") String passwort
    )
    {
        //access database - check user
        //create session if true

        //return 200 if ok
        // return 406 if not ok - bad username/password

        UserDataAccess dao = new UserDataAccess();
        dao.checkPassword("test", "test");

        UserService userService = new UserService("test_user","customer");

        return Response.ok(userService).build();
    }

}
