package org.sid.springsecurity.bean.voitureBean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.sid.springsecurity.bean.communBean.Client;
import org.sid.springsecurity.bean.communBean.Paiement;
import org.sid.springsecurity.security.bean.AppUser;

import javax.persistence.*;

import java.util.List;

@Entity
public class AgenceLocation extends AppUser {
    private Long iceAgLoc;
    private String raisonSocialAg;
    private String adresse;
    private int numTelephone;
    private int numCompteBkAgLoc;
    private Long ribAgenceLoc;
    private Long RCAgLoc ;

    @JsonIgnore
    @OneToMany(mappedBy = "agenceLocation")
    private List<Voiture> voitures;

    @JsonIgnore
    @OneToMany(mappedBy = "agenceLocation")
    private List<Client> clients ;

    @JsonIgnore
    @OneToMany(mappedBy = "agenceLocation")
    private List<Paiement> paiements ;

    public AgenceLocation() {

    }


    public Long getIceAgLoc() {
        return iceAgLoc;
    }

    public void setIceAgLoc(Long iceAgLoc) {
        this.iceAgLoc = iceAgLoc;
    }

    public String getRaisonSocialAg() {
        return raisonSocialAg;
    }

    public void setRaisonSocialAg(String raisonSocialAg) {
        this.raisonSocialAg = raisonSocialAg;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    public int getNumCompteBkAgLoc() {
        return numCompteBkAgLoc;
    }

    public void setNumCompteBkAgLoc(int numCompteBkAgLoc) {
        this.numCompteBkAgLoc = numCompteBkAgLoc;
    }

    public Long getRibAgenceLoc() {
        return ribAgenceLoc;
    }

    public void setRibAgenceLoc(Long ribAgenceLoc) {
        this.ribAgenceLoc = ribAgenceLoc;
    }


    public Long getRCAgLoc() {
        return RCAgLoc;
    }

    public void setRCAgLoc(Long RCAgLoc) {
        this.RCAgLoc = RCAgLoc;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
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

    public AgenceLocation( Long iceAgLoc, String raisonSocialAg, String adresse, int numTelephone, int numCompteBkAgLoc, Long ribAgence_Loc , Long RCAgLoc, List<Voiture> voitures, List<Client> clients, List<Paiement> paiements) {
        this.iceAgLoc = iceAgLoc;
        this.raisonSocialAg = raisonSocialAg;
        this.adresse = adresse;
        this.numTelephone = numTelephone;
        this.numCompteBkAgLoc = numCompteBkAgLoc;
        this.ribAgenceLoc = ribAgence_Loc;
        this.RCAgLoc = RCAgLoc;
        this.voitures = voitures;
        this.clients = clients;
        this.paiements = paiements;
    }
}
