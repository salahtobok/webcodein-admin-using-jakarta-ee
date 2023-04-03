package com.webcodein.common.functionalRequirements.restResource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/reactiveHello")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ReactiveHelloResource {

    @Path("{name}")
    @GET
    public CompletionStage<String> hello(@PathParam("name") String name) {
        CompletableFuture<String> future = new CompletableFuture<>();


        future.complete("Reactive Hello " + name + "!");

        return future;
    }

}