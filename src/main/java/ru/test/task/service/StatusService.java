package ru.test.task.service;

import org.springframework.stereotype.Service;
import ru.test.task.dto.Request;
import ru.test.task.dto.Response;

import java.io.IOException;

@Service
public interface StatusService {
    Response saveData(Request request) throws IOException;
}
