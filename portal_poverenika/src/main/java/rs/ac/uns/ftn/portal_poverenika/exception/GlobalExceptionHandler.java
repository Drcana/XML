package rs.ac.uns.ftn.portal_poverenika.exception;

import org.exist.http.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    private static final String EXCEPTION_MESSAGE = "Request: {} threw an exception: {}";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handle(NotFoundException ex, HttpServletRequest request) {

        logger.error(EXCEPTION_MESSAGE, request.getRequestURL(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<String> handle(InvalidDateException ex, HttpServletRequest request) {

        logger.error(EXCEPTION_MESSAGE, request.getRequestURL(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(NotRejectedZahtevException.class)
    public ResponseEntity<String> handle(
            NotRejectedZahtevException ex, HttpServletRequest request) {

        logger.error(EXCEPTION_MESSAGE, request.getRequestURL(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(ProcessSuspendedException.class)
    public ResponseEntity<String> handle(
            ProcessSuspendedException ex, HttpServletRequest request) {

        logger.error(EXCEPTION_MESSAGE, request.getRequestURL(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

}
