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


    @Path("delayed/{name}")
    @GET
    public CompletionStage<String> delayedHello(@PathParam("name") String name) {
        System.out.println("Delayed ReactiveHello webservice checked for name : "+name);

        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(()->{
            try {
                // 20 Seconds
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
                return;
            }
            future.complete("Delayed Reactive Hello "+name+"!");

        }).start();
        return future;
    }
}
