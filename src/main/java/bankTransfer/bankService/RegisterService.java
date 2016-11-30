package bankTransfer.bankService;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterService
{
    @JsonProperty
    private String Nachname;

    @JsonProperty
    private String Vorname;
    
    @JsonProperty
	private Date Geburtsdatum;
    
    @JsonProperty
	private String Strasse;
    
    @JsonProperty
	private String Ort;
    
    @JsonProperty
	private String PLZ;
    
    public RegisterService(String Nachname, String Vorname, Date Geburtsdatum, String Strasse, String Ort, String PLZ)
    {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geburtsdatum = Geburtsdatum;
        this.Strasse = Strasse;
        this.Ort = Ort;
        this.PLZ = PLZ;
        
    }
    public String getName() {
        return Nachname;
    }

    public void setName(String Nachname) {
        this.Nachname = Nachname;
    }

    public String getFirst_name() {
        return Vorname;
    }

    public void setFirst_name(String Vorname) {
        this.Vorname = Vorname;
    }
}
