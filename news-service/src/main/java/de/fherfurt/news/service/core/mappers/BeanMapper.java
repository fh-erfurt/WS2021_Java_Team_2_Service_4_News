package de.fherfurt.news.service.core.mappers;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import org.mapstruct.InheritInverseConfiguration;

public interface BeanMapper<ENTITY extends BaseBusinessEntity, DTO> {
    public DTO toDto(final ENTITY entity);

    @InheritInverseConfiguration
    public ENTITY fromDto(final DTO dto);

    static<ENTITY extends BaseBusinessEntity, DTO> DTO mapToDto(final ENTITY entity) {
        final BeanMapper<ENTITY, DTO> beanMapper = UtilityMapper.getMapperBy(entity.getClass(), UtilityMapper.MapperTargets.ENTITY);

        return beanMapper.toDto(entity);
    }

    static<ENTITY extends BaseBusinessEntity, DTO> ENTITY mapToEntity(final DTO dto) {
        final BeanMapper<ENTITY, DTO> beanMapper = UtilityMapper.getMapperBy(dto.getClass(), UtilityMapper.MapperTargets.DTO);

        return beanMapper.fromDto(dto);
    }
}
