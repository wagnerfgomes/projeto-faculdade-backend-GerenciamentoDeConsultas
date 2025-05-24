package br.com.projeto.apigerenciamentodeestoque.exception;

import ch.qos.logback.core.spi.ErrorCodes;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException apiException){
        return ResponseEntity.status(HttpStatusCode.valueOf(apiException.getStatusCode())).body(Map.of(
                "erro", apiException.getErrCode(),
                "status", apiException.getStatusCode(),
                "message", apiException.getMessage()));
    }
}
