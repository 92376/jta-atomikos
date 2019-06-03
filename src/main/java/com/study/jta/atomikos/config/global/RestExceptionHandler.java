package com.study.jta.atomikos.config.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujing
 * @since 2019/5/31 15:54
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Map<Integer, String> exceptionHandler(Exception e) {
        log.error(e.getClass().getName(), e);
        Map<Integer, String> map = new HashMap<>(16);
        map.put(4, "系统异常");
        return map;
    }

}