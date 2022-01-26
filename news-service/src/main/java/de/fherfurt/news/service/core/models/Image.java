package de.fherfurt.news.service.core.models;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Image extends BaseBusinessEntity {
    private String path;

    @Builder (setterPrefix = "with")

    public Image(int id, String path) {
        super(id);
        this.path = path;
    }
}
