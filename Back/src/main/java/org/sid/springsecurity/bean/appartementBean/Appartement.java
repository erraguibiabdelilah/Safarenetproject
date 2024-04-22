package org.sid.springsecurity.bean.appartementBean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sid.springsecurity.bean.communBean.Reservation;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "appartement")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Appartement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private int superficie;

    private String adresse;

    private double loyerMensuel;

    @OneToMany
    private List<Reservation> reservation;

    @ManyToOne
    @JoinColumn(name = "categoriesAppartement_id")
    private CategoriesAppartement categoriesAppartement;

    @ManyToOne
    @JoinColumn(name = "propAppartement_id")
    private PropAppartement propAppartement;


    public PropAppartement getPropAppartement() {
        return propAppartement;
    }

    public void setPropAppartement(PropAppartement propAppartement) {
        this.propAppartement = propAppartement;
    }

    public Appartement(Long id, String code, int superficie, String adresse, double loyerMensuel, List<Reservation> reservation, CategoriesAppartement categoriesAppartement, PropAppartement propAppartement) {
        this.id = id;
        this.code = code;
        this.superficie = superficie;
        this.adresse = adresse;
        this.loyerMensuel = loyerMensuel;
        this.reservation = reservation;
        this.categoriesAppartement = categoriesAppartement;
        this.propAppartement = propAppartement;
    }

    public Appartement() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLoyerMensuel() {
        return loyerMensuel;
    }

    public void setLoyerMensuel(double loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public CategoriesAppartement getCategoriesAppartement() {
        return categoriesAppartement;
    }

    public void setCategoriesAppartement(CategoriesAppartement categoriesAppartement) {
        this.categoriesAppartement = categoriesAppartement;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
