package de.fherfurt.news.service.core.mappers;

import de.fherfurt.news.client.MessageDto;
import de.fherfurt.news.service.message.entity.Message;
import de.fherfurt.news.service.message.boundary.MessageMapper;
import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilityMapper {
    public static UtilityMapper newInstance() {
        return new UtilityMapper();
    }

    private static final List<Triple<Class<?>, Class<?>, BeanMapper<?, ?>>> MAPPERS = List.of(
        Triple.of(Message.class, MessageDto.class, MessageMapper.INSTANCE)
    );

    @SuppressWarnings("unchecked")
    static <E extends BaseBusinessEntity, D> BeanMapper<E, D> getMapperBy(final Class<?> type, final MapperTargets target) {
        final Function<Triple<Class<?>, Class<?>, ? extends BeanMapper<?, ?>>, Class<?>> typeSupplier = MapperTargets.ENTITY.equals(target) ? Triple::getLeft : Triple::getMiddle;

        return MAPPERS.stream()
                .filter(mapper -> Objects.equals(type, typeSupplier.apply(mapper)))
                .findFirst()
                .map(mapper -> (BeanMapper<E, D>) mapper.getRight())
                .orElseThrow(() -> new NullPointerException("Could not find mapper for " + target.name().toLowerCase() + " type '" + type.getSimpleName() + "'."));
    }

    enum MapperTargets {
        ENTITY,
        DTO
    }
}
