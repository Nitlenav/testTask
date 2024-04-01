package ru.test.task.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.task.dto.Request;
import ru.test.task.dto.Response;

import java.io.IOException;

@RequestMapping("/api")
@OpenAPIDefinition(info = @Info(title = "Сохранения данных пользователя", description = "Сервис сохранения данных пользователя"))
public interface StatusRestController {

    @Operation(summary = "Сохранение  статуса")
    @PostMapping("/add_data")
    Response addData(@RequestBody Request request) throws IOException;

}
