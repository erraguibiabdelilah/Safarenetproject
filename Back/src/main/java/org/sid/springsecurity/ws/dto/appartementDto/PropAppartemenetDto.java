package org.sid.springsecurity.ws.dto.appartementDto;
public class PropAppartemenetDto {



    private Long id;
    private String nom;
    private String prenom;
    private String numTele;
    private String email;
    private String ribPropAppt;
    private String numCompteBkPropApp;
    private String cin;
    private String username;
    private String password;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTele() {
        return numTele;
    }

    public void setNumTele(String numTele) {
        this.numTele = numTele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRibPropAppt() {
        return ribPropAppt;
    }

    public void setRibPropAppt(String ribPropAppt) {
        this.ribPropAppt = ribPropAppt;
    }

    public String getNumCompteBkPropApp() {
        return numCompteBkPropApp;
    }

    public void setNumCompteBkPropApp(String numCompteBkPropApp) {
        this.numCompteBkPropApp = numCompteBkPropApp;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
