package com.github.cen1.rest;

//import com.kumuluz.ee.logs.LogManager;
//import com.kumuluz.ee.logs.Logger;

import javax.annotation.Priority;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Priority(1)
@Provider
public class MyValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    //private static final Logger LOG = LogManager.getLogger(MyValidationExceptionMapper.class.getName());

    @Override
    public Response toResponse(ValidationException e) {
        //LOG.error("We got into custom MyValidationExceptionMapper");
        System.out.println("We got into custom MyValidationExceptionMapper");
        return Response.serverError().build();
    }
}