package org.jacques_wentworth.springdocdemo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/ping")
    @Operation(summary = "Ping end point", description = "The ping end point is used for liveliness checks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))
                    }
            )
    })
    public String ping() {
        return "pong";
    }

    @Operation(summary = "Get a person by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the person",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Person.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Person findById(@Parameter(description = "id of person to be searched")
                           @PathVariable long id) {
        return Person.builder()
                .id(id)
                .name("Person " + id)
                .build();
    }

}
