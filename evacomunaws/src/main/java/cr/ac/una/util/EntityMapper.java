package cr.ac.una.util;

/**
 * 
 * @author arayaroma
 */
public interface EntityMapper<E, D> {

    D convertFromEntityToDTO(E entity, D dto);

    E convertFromDTOToEntity(D dto, E entity);
}
