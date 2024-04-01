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
public class Request {

    @Schema(description = "Идентификатор пользователя")
    @NotNull
    @JsonProperty("user_id")
    Integer userId;

    @Schema(description = "Данные пользователя")
    @NotNull
    @JsonProperty("user_data")
    String useData;


    @Override
    public String toString() {
        return "user_id:" + userId + " user_data:" + useData;
    }
}
