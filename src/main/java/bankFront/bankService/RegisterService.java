package bankFront.bankService;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterService
{
    @JsonProperty
    private String Nachname;

    @JsonProperty
    private String Vorname;
    
    @JsonProperty
	private String Geburtsdatum;
    
    @JsonProperty
	private String Strasse;
    
    @JsonProperty
	private String Ort;
    
    @JsonProperty
	private String PLZ;
    
    @JsonProperty
	private String Passwort;

    @JsonProperty
	private String message;

    public RegisterService(String Nachname, String Vorname, String Geburtsdatum, String Strasse, String Ort, String PLZ, String Passwort)
    {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geburtsdatum = Geburtsdatum;
        this.Strasse = Strasse;
        this.Ort = Ort;
        this.PLZ = PLZ;
        this.Passwort = Passwort;
        
    }

    public RegisterService(String Nachname, String Vorname, String message)
    {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.message = message;

    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getPasswort() { return Passwort; }

    public void setPasswort(String passwort) { Passwort = passwort;  }
}
