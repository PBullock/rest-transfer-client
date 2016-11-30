package bankFront.resources;



import bankFront.bankService.RegisterService;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
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
    		
        // send request to register micro service
        //

        WebTarget target =  this.target("http://localhost:18183/api/");
        target.register(String.class);

        WebTarget resourceTarget = target.path("register/user");
        resourceTarget.queryParam("Name","test_name");

        Invocation.Builder invocationBuilder =
                resourceTarget.request(MediaType.APPLICATION_JSON);
        //invocationBuilder.header("some-header", "true");

        Form form = new Form();
        form.param("Name","test_name");

        Response response = invocationBuilder.post(Entity.form(form));

        RegisterService registerService = new RegisterService(Nachname, Vorname, Geburtsdatum, Strasse, Ort, PLZ);
        return Response.ok(registerService).build();
    }
}
