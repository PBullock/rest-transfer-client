package bankFront;

import io.dropwizard.auth.Authorizer;

/**
 * Created by Peter on 26/11/2016.
 */
public class BankRegisterAuthorizer implements Authorizer<User>
{
    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("test_user") && role.equals("ADMIN");
    }
}
