package com.rank.casinoassessment.exception;

import com.rank.casinoassessment.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RankCasinoException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RankCasinoBadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(RankCasinoBadRequestException exception){
        String errorMessage = exception.getMessage();
        ApiError apiError = new ApiError(LocalDateTime.now(),HttpStatus.BAD_REQUEST, errorMessage);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(RankCasinoTeapotException.class)
    public ResponseEntity<Object> handleTeapot(RankCasinoTeapotException exception){
        String errorMessage = exception.getMessage();
        ApiError apiError = new ApiError(LocalDateTime.now(),HttpStatus.I_AM_A_TEAPOT, errorMessage);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(apiError);
    }

}
