package com.hyundai.booking.CarTestdrive.controller;

import com.hyundai.booking.CarTestdrive.common.CommonRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<Object> success(Object data) {
        return new ResponseEntity(new CommonRs(HttpStatus.OK.value(), "success", data), HttpStatus.OK);
    }

    public ResponseEntity<Object> error(Object data) {
        return new ResponseEntity(new CommonRs(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", data), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> badRequest(Object data) {
        return new ResponseEntity(new CommonRs(HttpStatus.BAD_REQUEST.value(), "bad_request", data), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> notFound(Object data) {
        return new ResponseEntity(new CommonRs(HttpStatus.NOT_FOUND.value(), "not_found", data), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> forbidden(Object data) {
        return new ResponseEntity(new CommonRs(HttpStatus.FORBIDDEN.value(), "forbidden", data), HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<Object> success(Object data, String message) {
        return new ResponseEntity(new CommonRs(HttpStatus.OK.value(), message, data), HttpStatus.OK);
    }

    public ResponseEntity<Object> badRequest(Object data, String message) {
        return new ResponseEntity(new CommonRs(HttpStatus.BAD_REQUEST.value(), message, data), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> forbidden(Object data, String message) {
        return new ResponseEntity(new CommonRs(HttpStatus.FORBIDDEN.value(), message, data), HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<Object> notFound(Object data, String message) {
        return new ResponseEntity(new CommonRs(HttpStatus.NOT_FOUND.value(), message, data), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> error(HttpStatus httpStatus, Object message) {
        return new ResponseEntity(new CommonRs(httpStatus.value(), "error", message), httpStatus);
    }
}
