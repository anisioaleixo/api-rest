package br.com.anisioaleixo.api_rest.excepition.handler;

import br.com.anisioaleixo.api_rest.excepition.ExceptionResponse;
import br.com.anisioaleixo.api_rest.excepition.UnsupportedMathOperationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception ex, WebRequest request) {;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new java.util.Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handlerBadRequestExcepition(Exception ex, WebRequest request) {;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new java.util.Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
