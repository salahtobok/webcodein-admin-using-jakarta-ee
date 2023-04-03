package com.webcodein.common.functionalRequirements.restResource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class HelloRemoteResource {

    @Path("{name}")
    @GET
    public String hello(@PathParam("name") String name) {
        return "Hello " + name + "!";
    }

}
