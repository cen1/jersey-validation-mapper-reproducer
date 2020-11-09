package com.github.cen1.rest;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MyFeature implements Feature {

    @Override
    public boolean configure(final FeatureContext context) {
        context.register(new MyBinder());
        return true;
    }
}
