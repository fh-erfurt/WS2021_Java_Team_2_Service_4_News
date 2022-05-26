package de.fherfurt.news.client;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class ImageDto {
    private Long id;
    private String filePath;
    private byte[] content;
}
