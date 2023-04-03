package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerInterceptors;

import com.webcodein.common.nonFunctionalRequirements.utils.GeneralUtil;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Provider
public class CommonReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Check ReaderInterceptorContext ====================> 03 :");
        InputStream is = context.getInputStream();
        String body = new BufferedReader(new InputStreamReader(is)).lines()
                .collect(Collectors.joining("\n"));
        context.setInputStream(new ByteArrayInputStream(
                (body).getBytes()));
        try {
            // Check if the body is going to deserialize or not to LazyFilterModel object
            // If not redirect to WebApplicationException with Bad Request response
            Jsonb jsonb = JsonbBuilder.create();
            return context.proceed();
        } catch (Exception exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, () -> "Log Cause Message ===> : "+exception.getMessage());
            GeneralUtil.logRootCauseMessage(exception,context.getClass());
            throw new WebApplicationException(Response.status(400).build());
        }
    }
}