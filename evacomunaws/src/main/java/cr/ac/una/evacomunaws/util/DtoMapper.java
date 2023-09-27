package cr.ac.una.evacomunaws.util;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author arayaroma
 */
public interface DtoMapper<E, D> {

    D convertFromEntityToDTO(E entity, D dto);

    E convertFromDTOToEntity(D dto, E entity);

    public static <E, D> ListWrapper<D> fromEntityList(List<E> entities, Class<D> dtoClass) {
        ListWrapper<D> listWrapper = new ListWrapper<>();
        if (entities == null || entities.isEmpty()) {
            return listWrapper;
        }
        List<D> dtos = entities.stream()
                .map(entity -> convertToDto(entity, dtoClass))
                .collect(Collectors.toList());
        listWrapper.setList(dtos);
        return listWrapper;
    }

    public static <E, D> ListWrapper<E> fromDtoList(List<D> dtos, Class<E> entityClass) {
        ListWrapper<E> listWrapper = new ListWrapper<>();
        if (dtos == null || dtos.isEmpty()) {
            return listWrapper;
        }
        List<E> entities = dtos.stream()
                .map(dto -> convertToEntity(dto, entityClass))
                .collect(Collectors.toList());
        listWrapper.setList(entities);
        return listWrapper;
    }

    public static <T, D> D convertToDto(T entity, Class<D> dtoClass) {
        try {
            dtoClass.getConstructor(entity.getClass());
            Constructor<D> constructor = dtoClass.getConstructor(entity.getClass());
            D dto = constructor.newInstance(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error converting entity to DTO", e);
        }
    }

    public static <T, D> T convertToEntity(D dto, Class<T> entityClass) {
        try {
            Constructor<T> constructor = entityClass.getConstructor(dto.getClass());
            T entity = constructor.newInstance(dto);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error converting DTO to entity", e);
        }
    }
}
