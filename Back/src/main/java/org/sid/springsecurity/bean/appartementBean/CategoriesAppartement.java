package org.sid.springsecurity.bean.appartementBean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoriesAppartement")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriesAppartement {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "categoriesAppartement",cascade = CascadeType.REMOVE)
    private List<Appartement> appartement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Appartement> getAppartement() {
        return appartement;
    }

    public void setAppartement(List<Appartement> appartement) {
        this.appartement = appartement;
    }

    public CategoriesAppartement(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public CategoriesAppartement() {
    }
}
