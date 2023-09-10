package cr.ac.una.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Angelo2002
 * @author arayaroma
 **/
public class EntityUtil {

    public static <E, D> ListWrapper<D> fromEntityList(List<E> entities, Function<E, D> mapper) {
        ListWrapper<D> listWrapper = new ListWrapper<>();
        if (entities != null && !entities.isEmpty()) {
            List<D> dtos = entities.stream()
                    .map(mapper)
                    .collect(Collectors.toList());

            listWrapper.setList(dtos);
        }
        return listWrapper;
    }

    public static <T> ResponseWrapper verifyEntity(T entity, Class<T> clazz) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);

        if (!constraintViolations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> cv : constraintViolations) {
                System.err
                        .println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                message.append(cv.getRootBeanClass().getSimpleName()).append(".").append(cv.getPropertyPath())
                        .append(" ").append(cv.getMessage());
            }
            return new ResponseWrapper(
                    ResponseCode.UNPROCESSABLE_ENTITY.getCode(),
                    ResponseCode.UNPROCESSABLE_ENTITY,
                    clazz.getSimpleName() + " can't be processed, validation error: " + message,
                    null);
        }
        return null;
    }
}
