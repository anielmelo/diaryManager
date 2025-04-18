package br.edu.ifpb.esperanca.ads.diarymanager.diary.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.ifpb.esperanca.ads.diarymanager.diary.domain.exception.DomainException;
import br.edu.ifpb.esperanca.ads.diarymanager.diary.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<BaseError> handleDomainException(DomainException ex, HttpServletRequest request) {
        BaseError error = new BaseError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<BaseError> handleServiceException(ServiceException ex, HttpServletRequest request) {
        BaseError error = new BaseError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
