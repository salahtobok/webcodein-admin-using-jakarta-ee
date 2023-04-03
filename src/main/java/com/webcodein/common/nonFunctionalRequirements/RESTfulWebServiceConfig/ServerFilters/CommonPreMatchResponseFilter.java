package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerFilters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Provider
@PreMatching
public class CommonPreMatchResponseFilter implements ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check PreMatchResponseFilter ====================> 04 : "+responseContext.getStatus());
    }
}