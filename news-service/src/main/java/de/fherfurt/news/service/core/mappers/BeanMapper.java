package de.fherfurt.news.service.core.mappers;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface BeanMapper<ENTITY extends BaseBusinessEntity, DTO> {
    public DTO toDto(final ENTITY entity);

    @InheritInverseConfiguration
    public ENTITY fromDto(final DTO dto);

    /**
     * Deeply clones the entity.
     *
     * @param toClone Entity to clone
     * @return Cloned entity
     */
    ENTITY clone(ENTITY toClone);

    /**
     * Deeply clones the DTO.
     *
     * @param toClone DTO to clone
     * @return Cloned DTO
     */
    DTO clone(DTO toClone);

    @Ignore
    static<ENTITY extends BaseBusinessEntity, DTO> DTO mapToDto(final ENTITY entity) {
        final BeanMapper<ENTITY, DTO> beanMapper = UtilityMapper.getMapperBy(entity.getClass(), UtilityMapper.MapperTargets.ENTITY);

        return beanMapper.toDto(entity);
    }

    @Ignore
    static<ENTITY extends BaseBusinessEntity, DTO> ENTITY mapToEntity(final DTO dto) {
        final BeanMapper<ENTITY, DTO> beanMapper = UtilityMapper.getMapperBy(dto.getClass(), UtilityMapper.MapperTargets.DTO);

        return beanMapper.fromDto(dto);
    }
}
