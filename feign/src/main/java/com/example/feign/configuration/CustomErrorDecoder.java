package com.example.feign.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // 根據 HTTP 狀態碼回傳不同的例外類別
        switch (response.status()) {
            case 400:
                return new ResponseStatusException(HttpStatus.BAD_REQUEST, response.body().toString());
            case 401:
                return new ResponseStatusException(HttpStatus.UNAUTHORIZED, response.body().toString());
            case 404:
                return new ResponseStatusException(HttpStatus.NOT_FOUND, response.body().toString());
            default:
                return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, response.body().toString());
        }
    }
}
