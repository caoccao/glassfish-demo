package com.caoccao.glassfish.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.time.ZonedDateTime;

@Path("/")
public class RootResource {
    @GET
    @Path("hello")
    public Response getRoot() {
        String now = ZonedDateTime.now().toString();
        return Response
                .status(Response.Status.OK)
                .entity("Hello World!<br/>" + now)
                .build();
    }
}
