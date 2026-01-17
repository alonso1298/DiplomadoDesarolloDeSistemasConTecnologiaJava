package unam.diplomado.pixup.colonia.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ColoniaRequestDTO(
        @NotBlank(message = "Nombre es requerido")
        String nombre,
        @Pattern(regexp="^(\\d{5}$)",
                message="Formato no válido para código postal")
        String cp,
        @NotNull(message = "La colonia debe estar asociada a un municipio")
        Integer municipio) {
}
