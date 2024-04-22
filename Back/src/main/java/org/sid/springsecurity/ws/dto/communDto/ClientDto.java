package org.sid.springsecurity.ws.dto.communDto;


import org.sid.springsecurity.ws.dto.appartementDto.PropAppartemenetDto;
import org.sid.springsecurity.ws.dto.voitureDto.AgenceLocationDto;

import java.util.List;
public class ClientDto {
    private String cin ;
    private String prenom ;
    private String nom ;
    private String nul_TeleClient  ;
    private String username_Client  ;
    private String password_Client  ;
    private String email_Client  ;
    private AgenceLocationDto agenceLocation;

    private PropAppartemenetDto propAppartemenetDto ;
    private List<ReservationDto> reservationDto ;


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

    public String getNul_TeleClient() {
        return nul_TeleClient;
    }

    public void setNul_TeleClient(String nul_TeleClient) {
        this.nul_TeleClient = nul_TeleClient;
    }

    public String getUsername_Client() {
        return username_Client;
    }

    public void setUsername_Client(String username_Client) {
        this.username_Client = username_Client;
    }

    public String getPassword_Client() {
        return password_Client;
    }

    public void setPassword_Client(String password_Client) {
        this.password_Client = password_Client;
    }

    public String getEmail_Client() {
        return email_Client;
    }

    public void setEmail_Client(String email_Client) {
        this.email_Client = email_Client;
    }



    public PropAppartemenetDto getPropAppartemenetDto() {
        return propAppartemenetDto;
    }

    public void setPropAppartemenetDto(PropAppartemenetDto propAppartemenetDto) {
        this.propAppartemenetDto = propAppartemenetDto;
    }

    public List<ReservationDto> getReservationDto() {
        return reservationDto;
    }

    public void setReservationDto(List<ReservationDto> reservationDto) {
        this.reservationDto = reservationDto;
    }

    public AgenceLocationDto getAgenceLocation() {
        return agenceLocation;
    }

    public void setAgenceLocation(AgenceLocationDto agenceLocation) {
        this.agenceLocation = agenceLocation;
    }
}
