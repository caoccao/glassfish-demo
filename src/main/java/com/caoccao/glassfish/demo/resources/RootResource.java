package com.caoccao.glassfish.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RootResource {
    @GET
    @Path("hello")
    public Response getRoot() {
        return Response.status(Response.Status.OK).entity("Hello World!").build();
    }
}
