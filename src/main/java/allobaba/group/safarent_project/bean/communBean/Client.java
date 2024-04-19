package allobaba.group.safarent_project.bean.communBean;

import allobaba.group.safarent_project.bean.appartementBean.PropAppartement;
import allobaba.group.safarent_project.bean.voitureBean.AgenceLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String cin ;
    private String prenom ;
    private String nom ;
    private String numTeleClient;
    private String usernameClient;
    private String passwordClient;
    private String emailClient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenceLocation_id")
    private AgenceLocation agenceLocation ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prop_appartement_id")
    private PropAppartement prop_appartement ;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservation ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumTeleClient() {
        return numTeleClient;
    }

    public void setNumTeleClient(String numTeleClient) {
        this.numTeleClient = numTeleClient;
    }

    public String getUsernameClient() {
        return usernameClient;
    }

    public void setUsernameClient(String usernameClient) {
        this.usernameClient = usernameClient;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public AgenceLocation getAgence_Location() {
        return agenceLocation;
    }

    public void setAgence_Location(AgenceLocation agence_Location) {
        this.agenceLocation = agence_Location;
    }

    public PropAppartement getProp_appartement() {
        return prop_appartement;
    }

    public void setProp_appartement(PropAppartement prop_appartement) {
        this.prop_appartement = prop_appartement;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public Client(Long id, String cin, String prenom, String nom, String numTeleClient, String usernameClient, String passwordClient, String emailClient, AgenceLocation agence_Location, PropAppartement prop_appartement, List<Reservation> reservation) {
        this.id = id;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.numTeleClient = numTeleClient;
        this.usernameClient = usernameClient;
        this.passwordClient = passwordClient;
        this.emailClient = emailClient;
        this.agenceLocation = agence_Location;
        this.prop_appartement = prop_appartement;
        this.reservation = reservation;
    }

    public Client() {

    }
}
