package bankFront.bankService;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Peter on 23/11/2016.
 */
public class AccountService {

    @JsonProperty private Integer Kontonummer;
    @JsonProperty private Integer Kunden_ID;
    @JsonProperty private Float   Guthaben;
    @JsonProperty private Float   Dispo;

    public AccountService () {}

    public Integer getKontonummer() {
        return Kontonummer;
    }

    public void setKontonummer(Integer kontonummer) {
        Kontonummer = kontonummer;
    }

    public Integer getKunden_ID() {
        return Kunden_ID;
    }

    public void setKunden_ID(Integer kunden_ID) {
        Kunden_ID = kunden_ID;
    }

    public Float getGuthaben() {
        return Guthaben;
    }

    public void setGuthaben(Float guthaben) {
        Guthaben = guthaben;
    }

    public Float getDispo() {
        return Dispo;
    }

    public void setDispo(Float dispo) {
        Dispo = dispo;
    }
}
