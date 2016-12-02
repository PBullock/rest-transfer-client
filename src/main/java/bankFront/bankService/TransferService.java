package bankFront.bankService;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Peter on 23/11/2016.
 */

public class TransferService {

    @JsonProperty private String Message;

    public TransferService ()  {}

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
