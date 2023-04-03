package com.webcodein.common.functionalRequirements.restResource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class HelloResource {

    @Path("{name}")
    @GET
    public String hello(@PathParam("name") String name) {
        System.out.println("Hello webservice checked for name : "+name);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello " + name + "!";
    }

}
