package com.testing.test_and_code.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
    @NotBlank(message = "Title can not be null or blank")
    @Size(max = 100,message = "Title can not nbe more then 100 character")
    private String title;
    @NotBlank(message = "Author name can not be null or blank")
    @Size(max = 100,message = "Title can not nbe more then 100 character")
    private String author;
}
