package de.fherfurt.news.service.message.entity;

import de.fherfurt.news.service.core.persistence.BaseBusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseBusinessEntity {
    @Getter
    String filePath;

    @Override
    public String toString() {
        return "Image{" +
                "filePath='" + filePath + '\'' +
                "id='" + getId() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(filePath, image.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath);
    }
}
