package org.jacques_wentworth.springdocdemo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@Builder
@Schema(name = "Person", description = "This is the Person schema")
public class Person {

    @NotBlank
    @Schema(name = "id", description = "This is the Person's primary key")
    private long id;

    @NotBlank
    @Size(min = 0, max = 200)
    @Schema(name = "name", description = "This is the Person's name")
    private String name;


}
