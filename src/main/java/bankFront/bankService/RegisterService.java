package bankFront.bankService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterService
{
    @JsonProperty
    private String name;

    @JsonProperty
    private String first_name;

    public RegisterService(String name, String first_name)
    {
        this.name = name;
        this.first_name = first_name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
