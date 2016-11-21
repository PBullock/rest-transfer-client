package bankTransfer.resources;

import bankTransfer.bankService.RegisterService;
import bankTransfer.bankService.UserService;
import org.glassfish.jersey.client.JerseyClient;
import org.objectweb.asm.commons.StaticInitMerger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RegisterResource {

    @Path("register")
    public class LoginResource extends JerseyClient {
        @Path("/newcustomer")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response register(
                @QueryParam("name") String name,
                @QueryParam("first_name") String first_name) {

            RegisterService registerService = new RegisterService(name, first_name);
            return Response.ok(registerService).build();
        }
    }
}
