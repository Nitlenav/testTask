package ru.test.task.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.test.task.dto.Request;
import ru.test.task.dto.Response;
import ru.test.task.service.StatusService;

import java.io.IOException;

@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StatusRestControllerImpl implements StatusRestController {

    StatusService statusService;

    @Override
    public Response addData(Request request) throws IOException {
        return statusService.saveData(request);
    }
}
