package bankTransfer;

import bankTransfer.client.BankTransferClient;
import bankTransfer.resources.LoginResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

public class BankTransferApp extends Application<BankTransferConf>
{
    public static void main(String[] args) throws Exception
    {
        new BankTransferApp().run(args);
    }

    @Override
    public void run(BankTransferConf configuration, Environment environment) throws Exception
    {
        final Client client = setupClient(environment);
        environment.jersey().register(new BankTransferClient(client));
        environment.jersey().register(new LoginResource());

    }

    private Client setupClient(Environment environment)
    {
        return new JerseyClientBuilder(environment).build("REST Client");
    }

    @Override
    public void initialize(Bootstrap<BankTransferConf> bankTransferConfBootstrap)
    {
        bankTransferConfBootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }


}
