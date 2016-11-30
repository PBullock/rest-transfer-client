package bankTransfer.resources;

import java.util.Date;

import bankTransfer.bankService.RegisterService;
import bankTransfer.bankService.UserService;

import org.glassfish.jersey.client.JerseyClient;
import org.objectweb.asm.commons.StaticInitMerger;

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
            @FormParam("Geburtsdatum") Date Geburtsdatum,
            @FormParam("Strasse") String Strasse,
            @FormParam("Ort") String Ort,
            @FormParam("PLZ") String PLZ){
    		
        //send request to register micro service
        //

        RegisterService registerService = new RegisterService(Nachname, Vorname, Geburtsdatum, Strasse, Ort, PLZ);
        return Response.ok(registerService).build();
    }
}
