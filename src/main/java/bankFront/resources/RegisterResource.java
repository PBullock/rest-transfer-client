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
            @FormParam("PLZ") String PLZ,
            @FormParam("Passwort") String Passwort
    ){

        // send request to register micro service
        WebTarget target =  this.target("http://localhost:18183/api/");
        target.register(String.class);

        WebTarget resourceTarget = target.path("register/user");


        Invocation.Builder invocationBuilder =
                resourceTarget.request(MediaType.APPLICATION_JSON);
        //@TODO: add apikey to deader for authorisation

        Form form = new Form();
        form.param("Nachname",Nachname);
        form.param("Vorname", Vorname);
        form.param("PLZ", PLZ);
        form.param("Ort", Ort);
        form.param("Strasse",Strasse);
        form.param("Geburtsdatum",Geburtsdatum);
        form.param("Passwort",Passwort);

        Response response = invocationBuilder.post(Entity.form(form));


        // @TODO: if ok response send details of new user back, or send error with message.

        RegisterService registerService = new RegisterService(Nachname, Vorname, "Danke");

        if(200 != response.getStatus()) {
            return Response.status(418).entity("{'message':'fail'}").build();
        }

        // get new konto for new customer - return in the response

        WebTarget kontoTarget =  this.target("http://localhost:18185/api/");
        kontoTarget.register(String.class);

        WebTarget kontoResourceTarget = kontoTarget.path("account");


        Invocation.Builder kontoInvocationBuilder =
                kontoResourceTarget.request(MediaType.APPLICATION_JSON);
        Form kontoForm = new Form();
//        kontoForm.param();  //Kunden_ID,
//        kontoForm.param();  //Dispo,
//        kontoForm.param();  //Guthaben,

        Response kontoResponse = kontoInvocationBuilder.post(Entity.form(kontoForm));

        return Response.ok(registerService).build();
    }




}
