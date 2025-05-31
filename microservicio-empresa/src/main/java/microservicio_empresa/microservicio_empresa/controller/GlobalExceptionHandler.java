package microservicio_empresa.microservicio_empresa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Excepsion global para todo controlador REST 
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Excepcion global para manejar errores
    // Si ocurre un exception usta este metodo
    @ExceptionHandler(RuntimeException.class)
    // Metodo, recibe parametro, retorna respuesta HTTP con el mensaje
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

// 400 Bad Request