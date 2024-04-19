package allobaba.group.safarent_project.ws.converter.voitureConverter;
import allobaba.group.safarent_project.bean.voitureBean.CategorieVoiture;
import allobaba.group.safarent_project.ws.dto.voitureDto.CategorieVoitureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CategorieVoitureConverter {
    public CategorieVoiture toBean(CategorieVoitureDto dto) {
        if(dto==null){
            return  null;
        }
        else {
            CategorieVoiture bean = new CategorieVoiture();
            bean.setId(dto.getId());
            bean.setLibelle(dto.getLibelle());

            return bean;
        }
    }
    public CategorieVoitureDto toDto(CategorieVoiture bean) {
        if(bean==null){
            return  null;
        }
        else {
            CategorieVoitureDto dto = new CategorieVoitureDto();
            dto.setId(bean.getId());
            dto.setLibelle(bean.getLibelle());

            return dto;
        }

    }
    public List<CategorieVoiture> toBean(List<CategorieVoitureDto> dtos) {
        List<CategorieVoiture> beans = new ArrayList<>();
        for (CategorieVoitureDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }

    public List<CategorieVoitureDto> toDto(List<CategorieVoiture> beans) {
        List<CategorieVoitureDto> dtos = new ArrayList<>();
        for (CategorieVoiture dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }
    private VoitureConverter voitureConverter;

    public CategorieVoitureConverter(@Lazy VoitureConverter voitureConverter) {
        this.voitureConverter = voitureConverter;
    }
}
