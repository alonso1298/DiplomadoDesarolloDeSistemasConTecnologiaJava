package dgtic.core.model.dto;

import lombok.Getter;

@Getter
public class Formulario2DTO {
    private Integer paisId;
    private Integer ciudadId;

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }
}
