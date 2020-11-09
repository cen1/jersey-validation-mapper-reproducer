package com.github.cen1.rest;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.internal.inject.CustomAnnotationLiteral;

import javax.inject.Singleton;
import javax.ws.rs.ext.ExceptionMapper;

public class MyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(new MyValidationExceptionMapper()).qualifiedBy(CustomAnnotationLiteral.INSTANCE)
            .to(ExceptionMapper.class).in(Singleton.class);
    }
}
