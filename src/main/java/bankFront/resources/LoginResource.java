package bankFront.resources;

import bankFront.bankService.UserService;
import bankFront.data.UserDataAccess;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class LoginResource extends JerseyClient
{
    @Path("/auth")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(
            @FormParam("Kontonummer") String Kontonummer,
            @FormParam("Passwort") String Passwort
    )
    {
        //access database - check user
        //create session if true

        //return 200 if ok
        // return 406 if not ok - bad username/password

        UserDataAccess dao = new UserDataAccess();
        Boolean auth = dao.checkPassword(Kontonummer, Passwort);

        if(!auth) {
            return Response.status(401).entity("{'message' : 'Bad login credentials'}").build();
        }

        WebTarget target =  this.target("http://localhost:18183/api/");
        target.register(String.class);

        WebTarget resourceTarget = target.path("register/user")
                .queryParam("Kontonummer", Kontonummer);

        Invocation.Builder invocationBuilder =
                resourceTarget.request(MediaType.APPLICATION_JSON);
        Response userResponse = invocationBuilder.get();

        if(200 != userResponse.getStatus()) {
            return Response.status(418).entity("{'message':'something went wrong'}").build();
        }


        return Response.ok(userResponse.getEntity()).build();
    }

}
