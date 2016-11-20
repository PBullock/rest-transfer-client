package bankTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class BankTransferConf extends Configuration
{
    @JsonProperty
    private String consumableValue;

    public String getConsumableValue()
    {
        return consumableValue;
    }
}
