package dgtic.core.validation;

import dgtic.core.model.dto.UsuarioDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NombresValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioDTO usuarioDTO=(UsuarioDTO) target;
        if(usuarioDTO.getNombre().equals("DGTIC")){
            errors.rejectValue("nombre","Novalido.usuario.nombre");
        }

    }
}
