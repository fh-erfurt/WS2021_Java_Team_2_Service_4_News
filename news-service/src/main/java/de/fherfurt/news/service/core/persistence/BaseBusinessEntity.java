package de.fherfurt.news.service.core.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Base definition for every entity type that wants to be storable via a repository.
 *
 */
@NoArgsConstructor
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class BaseBusinessEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Version
    @Getter
    @Setter
    private Long version;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @PrePersist
    void onCreate()
    {
        this.setCreated( new Date() );
    }

    @PreUpdate
    void onUpdate()
    {
        this.setModified( new Date() );
    }
}
