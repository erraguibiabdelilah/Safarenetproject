package allobaba.group.safarent_project.ws.dto.voitureDto;

import allobaba.group.safarent_project.bean.voitureBean.Voiture;
import jakarta.persistence.*;

import java.util.List;

public class CategorieVoitureDto {
    private Long id;
    private String libelle;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
