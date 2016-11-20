package bankTransfer.client;

import bankTransfer.BankTransferConf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces(MediaType.TEXT_PLAIN)
@Path("client")
public class BankTransferClient
{
    private Client client;
    public BankTransferClient(Client client) { this.client = client; }

    @GET
    @Path("login")
    public Response consumeLogin()
    {
        WebTarget login = client.target("http://localhost:18181")
                .path("api").path("login").path("test");
        Invocation.Builder invocationBuilder =
                login.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        System.out.println("Das ist der Response-Status..." + response.getStatus());
        return response;
    }
}
