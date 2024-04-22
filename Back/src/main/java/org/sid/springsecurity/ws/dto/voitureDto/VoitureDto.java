package org.sid.springsecurity.ws.dto.voitureDto;

import org.sid.springsecurity.ws.dto.communDto.ReservationDto;

import java.util.Date;
import java.util.List;

public class VoitureDto extends ModeleDto{

    private String couleur;
    private String photo;

    private int  nbrPlace;

    private String matricule;

    private int kiloMetrage;

    private String boitevitesse;

    private Date annee;

    private String ville;
    private Date dateMisecirculation;

    private Date dateAssurance;
    private Date sateVisitetechnique;



    private CategorieVoitureDto categorie;
    private AgenceLocationDto agenceLocation;
    private List<ReservationDto> reservation;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getKiloMetrage() {
        return kiloMetrage;
    }

    public void setKiloMetrage(int kiloMetrage) {
        this.kiloMetrage = kiloMetrage;
    }

    public String getBoitevitesse() {
        return boitevitesse;
    }

    public void setBoitevitesse(String boitevitesse) {
        this.boitevitesse = boitevitesse;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateMisecirculation() {
        return dateMisecirculation;
    }

    public void setDateMisecirculation(Date dateMisecirculation) {
        this.dateMisecirculation = dateMisecirculation;
    }

    public Date getDateAssurance() {
        return dateAssurance;
    }

    public void setDateAssurance(Date dateAssurance) {
        this.dateAssurance = dateAssurance;
    }

    public Date getSateVisitetechnique() {
        return sateVisitetechnique;
    }

    public void setSateVisitetechnique(Date sateVisitetechnique) {
        this.sateVisitetechnique = sateVisitetechnique;
    }

    public CategorieVoitureDto getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieVoitureDto categorie) {
        this.categorie = categorie;
    }

    public AgenceLocationDto getAgenceLocation() {
        return agenceLocation;
    }

    public void setAgenceLocation(AgenceLocationDto agenceLocationDto) {
        this.agenceLocation = agenceLocationDto;
    }

    public List<ReservationDto> getReservation() {
        return reservation;
    }

    public void setReservation(List<ReservationDto> reservation) {
        this.reservation = reservation;
    }
}
