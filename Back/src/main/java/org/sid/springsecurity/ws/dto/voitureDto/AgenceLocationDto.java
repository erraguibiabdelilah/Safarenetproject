package org.sid.springsecurity.ws.dto.voitureDto;


import org.sid.springsecurity.ws.dto.communDto.ClientDto;
import org.sid.springsecurity.ws.dto.communDto.PaiementDto;

import java.util.List;

public class AgenceLocationDto {
    private Long id;
    private Long iceAgLoc;
    private String raisonSocialAg;
    private String adresse;
    private int numTelephone;
    private int numCompteBkAgLoc;
    private Long ribAgenceLoc;
    private String usernameAgenceLoc;
    private String password;
    private Long RCAgLoc ;

    private List<VoitureDto> voitureDtos;
    private List<ClientDto> clientDtos ;
    private List<PaiementDto> paiementDtos ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getRibAgence_Loc() {
        return ribAgenceLoc;
    }

    public void setRibAgence_Loc(Long ribAgenceLoc) {
        this.ribAgenceLoc = ribAgenceLoc;
    }

    public String getUsernameAgenceLoc() {
        return usernameAgenceLoc;
    }

    public void setUsernameAgenceLoc(String usernameAgenceLoc) {
        this.usernameAgenceLoc = usernameAgenceLoc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRCAgLoc() {
        return RCAgLoc;
    }

    public void setRCAgLoc(Long RCAgLoc) {
        this.RCAgLoc = RCAgLoc;
    }

    public List<VoitureDto> getVoitureDtos() {
        return voitureDtos;
    }

    public void setVoitureDtos(List<VoitureDto> voitureDtos) {
        this.voitureDtos = voitureDtos;
    }

    public List<ClientDto> getClientDtos() {
        return clientDtos;
    }

    public void setClientDtos(List<ClientDto> clientDtos) {
        this.clientDtos = clientDtos;
    }

    public List<PaiementDto> getPaiementDtos() {
        return paiementDtos;
    }

    public void setPaiementDtos(List<PaiementDto> paiementDtos) {
        this.paiementDtos = paiementDtos;
    }
}
