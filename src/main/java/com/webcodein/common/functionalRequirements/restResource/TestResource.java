package com.webcodein.common.functionalRequirements.restResource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/asyncResponse")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class TestResource {

    @Path("suspended")
    @GET
    public void suspended(@Suspended AsyncResponse asyncResponse) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            asyncResponse.resume("Hello from AsyncResponse ");
        }).start();
    }

}
