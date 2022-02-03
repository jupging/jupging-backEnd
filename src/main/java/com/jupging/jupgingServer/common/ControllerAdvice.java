package com.jupging.jupgingServer.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.jupging.jupgingServer.common.BaseResponseStatus.DATABASE_ERROR;
import static com.jupging.jupgingServer.common.BaseResponseStatus.REQUEST_ERROR;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public BaseResponse<BaseResponseStatus> handleBaseException(BaseException e)
    {
        return new BaseResponse<>(e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<BaseResponseStatus> handleMethodArgumentNotValidException()
    {
        // valid 에러
        return new BaseResponse<>(REQUEST_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public BaseResponse<BaseResponseStatus> handleSQLException()
    {
        return new BaseResponse<>(DATABASE_ERROR);
    }
}
