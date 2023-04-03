package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerFilters;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Provider
public class CommonPostMatchRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check PostMatchRequestFilter ====================> 02 : ");
    }


}