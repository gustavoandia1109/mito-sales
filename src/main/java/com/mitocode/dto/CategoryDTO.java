package com.mitocode.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;

    @NotNull
//    @NotEmpty
//    @NotBlank
    @Size(min = 3, max = 20)
    private String nameofCategory;

    @NotBlank
    @Size(min = 3, max = 20)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;

    /*

    @Max(value = 10)
    @Min(value = 1)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "[0-9]+")
    private String phoneNumber;

     */
}
