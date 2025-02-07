package cz.tomkre.edu.spring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record Greeting(
    @NotNull
    @Size(min = 2, max = 2)
    String lang,
    @NotBlank(message = "Message must be defined")
    String message
) {}
