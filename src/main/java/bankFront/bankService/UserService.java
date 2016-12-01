package bankFront.bankService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserService {
    @JsonProperty private String Ort;
    @JsonProperty private String Strasse;
    @JsonProperty private String Geburtsdatum;
    @JsonProperty private Integer Kunden_ID;
    @JsonProperty private String PLZ;
    @JsonProperty private String Nachname;
    @JsonProperty private String Vorname;
    @JsonProperty private String userName;
    @JsonProperty private String userType;
    @JsonProperty private String userPassword;

    public UserService(String userName, String userType)
    {
        this.userName = userName;
        this.userType = userType;
    }

    public UserService(String userName, String userType, String userPassword)
    {
        this.userName = userName;
        this.userType = userType;
        this.userPassword = userPassword;
    }


    public UserService(String Nachname,
                       String Vorname,
                       String PLZ,
                       String Ort,
                       String Strasse,
                       String Geburtsdatum,
                       Integer Kunden_ID
    )
    {
        this.Nachname     = Nachname;
        this.Vorname      = Vorname;
        this.PLZ          = PLZ;
        this.Ort          = Ort;
        this.Strasse      = Strasse;
        this.Geburtsdatum = Geburtsdatum;
        this.Kunden_ID = Kunden_ID;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public Integer getKunden_ID() {
        return Kunden_ID;
    }

    public void setKunden_ID(Integer kunden_ID) {
        Kunden_ID = kunden_ID;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
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
}
