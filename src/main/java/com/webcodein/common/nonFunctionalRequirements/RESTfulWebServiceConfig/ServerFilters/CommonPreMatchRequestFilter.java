package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerFilters;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Provider
@PreMatching
public class CommonPreMatchRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check PreMatchRequestFilter ====================> 01 : ");
    }


}