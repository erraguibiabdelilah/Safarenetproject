package allobaba.group.safarent_project.bean.appartementBean;

import allobaba.group.safarent_project.bean.communBean.Client;
import allobaba.group.safarent_project.bean.communBean.Paiement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "propAppartemenet")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropAppartement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String numTele;
    private String email;
    private String ribPropAppt;
    private String numCompteBkPropApp;
    private String cin;
    private String usernamePropAppt;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "prop_appartement")
    private List<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy = "prop_appartement")
    private List<Paiement> paiements;

    @JsonIgnore
    @OneToMany(mappedBy = "propAppartement",cascade = CascadeType.REMOVE)
    private List<Appartement> appartementList;

    public PropAppartement(Long idPropAppartement, String nom, String prenom, String numTele, String email, String ribPropAppt, String numCompteBkPropApp, String cin, String usernamePropAppt, String password, List<Client> clients, List<Paiement> paiements, List<Appartement> appartementList) {
        this.id = idPropAppartement;
        this.nom = nom;
        this.prenom = prenom;
        this.numTele = numTele;
        this.email = email;
        this.ribPropAppt = ribPropAppt;
        this.numCompteBkPropApp = numCompteBkPropApp;
        this.cin = cin;
        this.usernamePropAppt = usernamePropAppt;
        this.password = password;
        this.clients = clients;
        this.paiements = paiements;
        this.appartementList = appartementList;
    }

    public List<Appartement> getAppartementList() {
        return appartementList;
    }

    public void setAppartementList(List<Appartement> appartementList) {
        this.appartementList = appartementList;
    }

    public PropAppartement() {

    }

    public Long getIdPropAppartement() {
        return id;
    }

    public void setIdPropAppartement(Long idPropAppartement) {
        this.id = idPropAppartement;
    }

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

    public String getUsernamePropAppt() {
        return usernamePropAppt;
    }

    public void setUsernamePropAppt(String usernamePropAppt) {
        this.usernamePropAppt = usernamePropAppt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}
