package cr.ac.una.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class EntityUtil {
    public static <T> ResponseWrapper verifyEntity(T entity, Class<T> clazz) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);

        if(!constraintViolations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> cv : constraintViolations) {
                System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                message.append(cv.getRootBeanClass().getSimpleName()).append(".").append(cv.getPropertyPath()).append(" ").append(cv.getMessage());
            }
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    clazz.getSimpleName() + " not created, validation error: " + message,
                    null);
        }
        return null;
    }
}
