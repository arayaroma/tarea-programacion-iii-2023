package cr.ac.una.repositories.impl;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.entities.Position;
import cr.ac.una.repositories.PositionRepository;
import cr.ac.una.util.Response;
import cr.ac.una.util.ResponseCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PositionRepositoryImpl implements PositionRepository {

    @PersistenceContext(unitName = "EvaComUNA")
    private EntityManager em;

    @Override
    public Response createPosition(PositionDto positionDto) {
        try {
            Position position = new Position(positionDto);
            em.persist(position);
            return new Response(true,
                    ResponseCode.OK,
                    "Position created successfully.",
                    new PositionDto(position));

        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating position.",
                    null);
        }
    }

    @Override
    public Response getPositionById(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position != null) {
                return new Response(true,
                        ResponseCode.OK,
                        "Position retrieved successfully.",
                        new PositionDto(position));
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }

        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while getting position by ID.",
                    null);
        }
    }

    @Override
    public Response updatePositionById(Long id, PositionDto position) {
        try {
            Position positionToUpdate = em.find(Position.class, id);
            if (positionToUpdate != null) {
                positionToUpdate.updatePosition(position);
                em.merge(positionToUpdate);
                return new Response(true,
                        ResponseCode.OK,
                        "Position updated successfully.",
                        new PositionDto(positionToUpdate));
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating position.",
                    null);
        }
    }

    @Override
    public Response deletePositionById(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position != null) {
                em.remove(position);
                return new Response(true,
                        ResponseCode.OK,
                        "Position deleted successfully.",
                        null);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting position.",
                    null);
        }
    }

}
