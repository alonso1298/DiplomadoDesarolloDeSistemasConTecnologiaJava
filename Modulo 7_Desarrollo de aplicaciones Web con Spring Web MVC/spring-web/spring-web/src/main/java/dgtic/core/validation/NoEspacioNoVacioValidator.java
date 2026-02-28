package dgtic.core.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoEspacioNoVacioValidator implements ConstraintValidator<INoEspacioNoVacio, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null || s.regionMatches(0, " ", 0,1) || s.isBlank()) {
            return false;
        }
        return true;
    }
}
