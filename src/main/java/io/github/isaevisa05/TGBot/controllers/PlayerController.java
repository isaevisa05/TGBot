package io.github.isaevisa05.TGBot.controllers;

import io.github.isaevisa05.TGBot.jdbc.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/getBalance")
    public String getBalance(@RequestParam(name = "login") String login) {
        return playerService.getBalance(login) + "";
    }

    /*@GetMapping("/read")
    public String readRequest(HttpServletRequest request) {

    }*/

    @GetMapping("/read")
    public String readRequest(HttpServletRequest request) {
        // Метод запроса
        String method = request.getMethod();

        // URI и параметры
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        // Заголовки
        StringBuilder headers = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headers.append(name).append(": ").append(request.getHeader(name)).append("\n");
        }

        return "Method: " + method + "\nURI: " + uri + "\nQuery: " + query + "\nHeaders:\n" + headers;
    }

    @RequestMapping("/read-all") // срабатывает на все методы: GET, POST, PUT, DELETE
    public String readAll(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();

        // Метод и URI
        sb.append("Method: ").append(request.getMethod()).append("\n");
        sb.append("URI: ").append(request.getRequestURI()).append("\n");
        sb.append("Query: ").append(request.getQueryString()).append("\n");

        // Заголовки
        sb.append("Headers:\n");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            sb.append(name).append(": ").append(request.getHeader(name)).append("\n");
        }

        // Тело запроса (для POST, PUT и других)
        byte[] bodyBytes = request.getInputStream().readAllBytes();
        if (bodyBytes.length > 0) {
            String body = new String(bodyBytes, StandardCharsets.UTF_8);
            sb.append("Body:\n").append(body).append("\n");
        } else {
            sb.append("Body: <empty>\n");
        }

        // Возвращаем как простой текст
        return sb.toString();
    }
}
