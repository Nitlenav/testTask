package ru.test.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Value
@Builder(toBuilder = true)
@Jacksonized
public class Response {

    @Schema(description = "Ответ")
    @NotNull
    @JsonProperty("answer")
    String answer;

}
