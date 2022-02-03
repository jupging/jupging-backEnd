package com.jupging.jupgingServer.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

import static com.jupging.jupgingServer.common.BaseResponseStatus.DATABASE_ERROR;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SQLException.class)
    public BaseResponse<BaseResponseStatus> handleError()
    {
        return new BaseResponse<>(DATABASE_ERROR);
    }
}
