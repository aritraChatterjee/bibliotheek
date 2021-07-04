package com.bibliotheek.api.dto;

import com.bibliotheek.model.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(name = "BookJson")
public class BookDto {
    @Schema(accessMode = READ_ONLY, description = "Book Id in long integer.")
    private long id;

    @Schema(description = "Title of the book.", example = "The Jungle Book", required = true)
    private String title;

    @Schema(description = "Language of the book.", enumAsRef = true, example = "EN")
    private Language language;

    @Schema(description = "List of authors.")
    private List<AuthorDto> authors;

    @Schema(description = "List of tags.", example = "[\"adventure\",\"fiction\"]", required = true)
    private List<String> tags;
}
