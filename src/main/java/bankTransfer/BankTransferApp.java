package bankTransfer;

import bankTransfer.client.BankTransferClient;
import bankTransfer.resources.LoginResource;
import bankTransfer.resources.RegisterResource;
import bankTransfer.resources.UserAccountResource;
import bankTransfer.resources.UserTransferResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

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
        environment.jersey().register(new RegisterResource());
        environment.jersey().register(new UserTransferResource());
        environment.jersey().register(new UserAccountResource());

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new BankRegisterAuthenticator())
                        .setAuthorizer(new BankRegisterAuthorizer())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
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
