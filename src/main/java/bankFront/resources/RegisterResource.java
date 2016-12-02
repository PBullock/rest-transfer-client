package bankFront.resources;



import bankFront.bankService.AccountService;
import bankFront.bankService.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        RegisterService registerService = null;
        AccountService accountService = null;
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

        Response response1 = invocationBuilder.post(Entity.form(form));


        // @TODO: if ok response send details of new user back, or send error with message.

        String registerJson = response1.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
             registerService = mapper.readValue(registerJson, RegisterService.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(200 != response1.getStatus()) {
            return Response.status(418).entity("{'message':'fail'}").build();
        }




        //@TODO get new konto for new customer - return in the response

        WebTarget kontoTarget =  this.target("http://localhost:18185/api/"); //account service url
        kontoTarget.register(String.class);

        WebTarget kontoResourceTarget = kontoTarget.path("account");
        Form kontoForm = new Form();
        kontoForm.param("Dispo", "5000");
        kontoForm.param("Guthaben", "100");
        kontoForm.param("Kunden_ID", registerService.getKunden_ID().toString());
        kontoForm.param("Hauptkonto", "1");

        Invocation.Builder kontoInvocationBuilder =
                kontoResourceTarget.request(MediaType.APPLICATION_JSON);
        Response accountResponse = kontoInvocationBuilder.post(Entity.form(kontoForm));
        Object account = accountResponse.getEntity();

        Response kontoResponse = kontoInvocationBuilder.post(Entity.form(kontoForm));

        String kontoJson = kontoResponse.readEntity(String.class);
        mapper = new ObjectMapper();

        try {
            accountService = mapper.readValue(kontoJson, AccountService.class);
            registerService.setKontonummer(accountService.getKontonummer());
        } catch (IOException e) {
            e.printStackTrace();
        }



        return Response.ok().entity(registerService).build();
    }




}
