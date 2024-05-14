package org.sid.springsecurity.ws.dto;

import java.util.Date;

public class NotificationReservationDto {
    private Long id;
    private String code;
    private String cinClient;
    private String nomClient;
    private String matriculeVoiture;
    private String codeAppartement;
    private String ice_Agence;
    private String cinPropAppartement;
    private Date dateReservation;
    private boolean isvisible;

    public boolean isIsvisible() {
        return isvisible;
    }

    public void setIsvisible(boolean isvisible) {
        this.isvisible = isvisible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getMatriculeVoiture() {
        return matriculeVoiture;
    }

    public void setMatriculeVoiture(String matriculeVoiture) {
        this.matriculeVoiture = matriculeVoiture;
    }

    public String getCodeAppartement() {
        return codeAppartement;
    }

    public void setCodeAppartement(String codeAppartement) {
        this.codeAppartement = codeAppartement;
    }

    public String getIce_Agence() {
        return ice_Agence;
    }

    public void setIce_Agence(String ice_Agence) {
        this.ice_Agence = ice_Agence;
    }

    public String getCinPropAppartement() {
        return cinPropAppartement;
    }

    public void setCinPropAppartement(String cinPropAppartement) {
        this.cinPropAppartement = cinPropAppartement;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
}
