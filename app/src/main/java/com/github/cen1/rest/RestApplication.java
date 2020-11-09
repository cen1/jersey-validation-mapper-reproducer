package com.github.cen1.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(MyRestResource.class);
        classes.add(MyValidationExceptionMapper.class);

        //classes.add(MyFeature.class);

        return classes;
    }
}
