package com.codedrop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.codedrop.model.SourceCode}
 */
@Value
public class SourceCodeDto implements Serializable {

    Integer id;

    @NotNull
    @Size(max = 255)
    String title;

    String image;

    Double price;

    @Size(max = 255)
    String slug;

    String linkDownload;

    String linkDemo;

    String commited;

    @Size(max = 255)
    String seoKeyword;

    @Size(max = 500)
    String shortDesc;

    String description;

    String tutorial;

    Boolean contract;

    Integer viewCount;

    Date createdAt;

    Date updatedAt;

    Boolean isDelete;
}