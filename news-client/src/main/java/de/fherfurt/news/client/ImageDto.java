package de.fherfurt.news.client;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class ImageDto {
    int id;
    private String path;
    private byte[] content;
}
