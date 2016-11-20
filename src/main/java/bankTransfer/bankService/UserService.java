package bankTransfer.bankService;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Peter on 20/11/2016.
 */
public class UserService {
    @JsonProperty
    private String userName;

    @JsonProperty
    private String userType;

    public UserService(String userName, String userType)
    {
        this.userName = userName;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
