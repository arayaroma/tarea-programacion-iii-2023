package cr.ac.una.evacomuna.util;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author arayaroma
 */
public interface DtoMapper<G, D> {

    D convertFromGeneratedToDTO(G generated, D dto);

    G convertFromDTOToGenerated(D dto, G generated);

    public static <E, D> ListWrapper<D> fromGeneratedList(List<E> generated, Class<D> dtoClass) {
        try {
            ListWrapper<D> listWrapper = new ListWrapper<>();
            if (generated == null || generated.isEmpty()) {
                return listWrapper;
            }
            List<D> dtos = generated.stream()
                    .map(gen -> convertToDto(gen, dtoClass))
                    .collect(Collectors.toList());
            listWrapper.setList(dtos);
            if (listWrapper == null) {
                return new ListWrapper<>();
            }
            return listWrapper;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public static <E, D> ListWrapper<E> fromDtoList(List<D> dtos, Class<E> generatedClass) {
        try {
            ListWrapper<E> listWrapper = new ListWrapper<>();
            if (dtos == null || dtos.isEmpty()) {
                return listWrapper;
            }
            List<E> generated = dtos.stream()
                    .map(dto -> convertToGenerated(dto, generatedClass))
                    .collect(Collectors.toList());
            listWrapper.setList(generated);
            if (listWrapper == null) {
                return new ListWrapper<>();
            }
            return listWrapper;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public static <T, D> D convertToDto(T generated, Class<D> dtoClass) {
        try {
            dtoClass.getConstructor(generated.getClass());
            Constructor<D> constructor = dtoClass.getConstructor(generated.getClass());
            D dto = constructor.newInstance(generated);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error converting Generated to DTO", e);
        }
    }

    public static <T, D> T convertToGenerated(D dto, Class<T> generatedClass) {
        try {
            Constructor<T> constructor = generatedClass.getConstructor(dto.getClass());
            T gen = constructor.newInstance(dto);
            return gen;
        } catch (Exception e) {
            throw new RuntimeException("Error converting DTO to Generated: " + e.toString(), e);
        }
    }
}
