package bankFront.resources;



import bankFront.bankService.RegisterService;
import com.sun.org.apache.xpath.internal.operations.Or;
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

//        resourceTarget.queryParam("Nachname",Nachname);
//        resourceTarget.queryParam("Vorname", Vorname);
//        resourceTarget.queryParam("Geburtsdatum",Geburtsdatum);
//        resourceTarget.queryParam("Strasse",Strasse);
//        resourceTarget.queryParam("Ort", Ort);
//        resourceTarget.queryParam("PLZ", PLZ);


        Invocation.Builder invocationBuilder =
                resourceTarget.request(MediaType.APPLICATION_JSON);
        //invocationBuilder.header("some-header", "true");

        Form form = new Form();
        form.param("Nachname",Nachname);
        form.param("Vorname", Vorname);
        form.param("PLZ", PLZ);
        form.param("Ort", Ort);
        form.param("Strasse",Strasse);
        form.param("Geburtsdatum",Geburtsdatum);

        Response response = invocationBuilder.post(Entity.form(form));

        RegisterService registerService = new RegisterService(Nachname, Vorname, Geburtsdatum, Strasse, Ort, PLZ);
        return Response.ok(registerService).build();
    }


}
