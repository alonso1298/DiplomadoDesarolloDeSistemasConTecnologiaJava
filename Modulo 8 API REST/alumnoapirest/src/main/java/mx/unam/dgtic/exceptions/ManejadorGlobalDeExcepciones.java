package mx.unam.dgtic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManejadorGlobalDeExcepciones {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex){
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body ("Manejado por Controller Advice: " + ex.getMessage());
//    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        Map<String, Object> respuesta = new HashMap<>();
        Map<String, String> errorDetalle = new HashMap<>();
        errorDetalle.put("mensaje", "El cuerpo esta mal formado");
        errorDetalle.put("status", "" + HttpStatus.BAD_REQUEST);
        Throwable causa =  ex.getMostSpecificCause();
        if (causa != null){
            errorDetalle.put("cause", causa.getMessage());
        }

        return ResponseEntity.badRequest().body(errorDetalle);
    }

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorDetalle = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errorDetalle.put(error.getField(), error.getDefaultMessage());
        });
        return  ResponseEntity.badRequest().body(errorDetalle);
    }
}
