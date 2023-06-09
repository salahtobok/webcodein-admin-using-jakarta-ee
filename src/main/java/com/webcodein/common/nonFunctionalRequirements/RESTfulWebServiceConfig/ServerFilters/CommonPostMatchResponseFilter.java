package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerFilters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Provider
public class CommonPostMatchResponseFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check PostMatchResponseFilter ====================> 05 :"+responseContext.getStatus());
    }
}