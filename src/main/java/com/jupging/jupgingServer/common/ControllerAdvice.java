package com.jupging.jupgingServer.common;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import java.sql.SQLException;

import static com.jupging.jupgingServer.common.BaseResponseStatus.*;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SQLException.class)
    public BaseResponse<BaseResponseStatus> handleSQLError()
    {
        return new BaseResponse<>(DATABASE_ERROR);
    }

    @ExceptionHandler(GoogleJsonResponseException.class)
    public BaseResponse<BaseResponseStatus> handleGoogleJsonResponseError()
    {
        return new BaseResponse<>(GCS_ERROR);
    }

    @ExceptionHandler(ServletException.class)
    public BaseResponse<BaseResponseStatus> handleServletExceptionError()
    {
        return new BaseResponse<>(FILE_EXTENSION_ERROR);
    }
}
