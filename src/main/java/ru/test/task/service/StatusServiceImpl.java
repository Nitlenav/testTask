package ru.test.task.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.test.task.dto.Request;
import ru.test.task.dto.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.springframework.http.HttpStatus.OK;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StatusServiceImpl implements StatusService {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    String path;

    public StatusServiceImpl(@Value("${path.to.file}")String path) {
        this.path = path;
    }

    @Override
    public Response saveData(Request request) {

        try {
            final String formatDate = DATE_TIME_FORMATTER.format(LocalDateTime.now());
            final String field = LF + formatDate + SPACE + request.toString();
            final Path path = getPathToResourcesFile();
            Files.writeString(path, field, StandardOpenOption.APPEND);
            return Response.builder().answer(OK.toString()).build();
        } catch (IOException e) {
            return Response.builder().answer(e.getMessage()).build();
        }

    }

    private Path getPathToResourcesFile() throws IOException {
        final Path pathFile = Paths.get(path);

        if (!Files.exists(pathFile)) {
            createFile();
        }
        return pathFile;
    }

    private void createFile() throws IOException {
        final String str = " Дата Время: Пользователь: Данные пользователя:";
        final File file = new File(path);
        final String absolutePath = file.getAbsolutePath();
        try (FileOutputStream outputStream = new FileOutputStream(absolutePath)){
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);
        }
    }
}
