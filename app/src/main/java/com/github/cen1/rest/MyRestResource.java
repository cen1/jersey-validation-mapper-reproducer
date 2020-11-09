package com.github.cen1.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/my")
public class MyRestResource {

    @POST
    public Response getMy(@NotNull MyRequestPojo in) {
        //this will throw on empty body
        return Response.ok("{}").build();
    }
}
