package bankFront.resources;

import java.util.Date;

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
            @FormParam("Nachname") String Nachname,
            @FormParam("Vorname") String Vorname,
            @FormParam("Geburtsdatum") String Geburtsdatum,
            @FormParam("Strasse") String Strasse,
            @FormParam("Ort") String Ort,
            @FormParam("PLZ") String PLZ){
    		
        //send request to register micro service
        //

        RegisterService registerService = new RegisterService(Nachname, Vorname, Geburtsdatum, Strasse, Ort, PLZ);
        return Response.ok(registerService).build();
    }
}
