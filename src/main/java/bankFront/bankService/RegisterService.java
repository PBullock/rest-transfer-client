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
	private Integer Kunden_ID;

    @JsonProperty
	private String message;

    @JsonProperty
    private Integer Kontonummer;

    // Default constructor
    public RegisterService(){}

    public RegisterService(String Nachname, String Vorname, String Geburtsdatum, String Strasse, String Ort, String PLZ, Integer Kunden_ID)
    {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geburtsdatum = Geburtsdatum;
        this.Strasse = Strasse;
        this.Ort = Ort;
        this.PLZ = PLZ;
        this.Kunden_ID = Kunden_ID;
        
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

    public void setNachname(String Nachname) {
        Nachname = Nachname;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        Vorname = Vorname;
    }

    public String getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(String Geburtsdatum) {
        Geburtsdatum = Geburtsdatum;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String Strasse) {
        Strasse = Strasse;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String Ort) {
        Ort = Ort;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getPasswort() { return Passwort; }

    public void setPasswort(String Passwort) { Passwort = Passwort;  }

    public Integer getKunden_ID() {
        return Kunden_ID;
    }

    public void setKunden_ID(Integer kunden_ID) {
        Kunden_ID = kunden_ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getKontonummer() {
        return Kontonummer;
    }

    public void setKontonummer(Integer kontonummer) {
        Kontonummer = kontonummer;
    }
}
