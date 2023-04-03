package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerInterceptors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Provider
public class CommonWriterInterceptor implements WriterInterceptor {


    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check WriterInterceptor ====================> 06 : ");

        context.proceed();
    }
}