package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig.ServerInterceptors;

import dz.eadn.common.business.LazyFilterModel;
import dz.eadn.common.controller.JsfUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
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
            LazyFilterModel lazyFilterModel = jsonb.fromJson(body, LazyFilterModel.class);
            return context.proceed();
        } catch (Exception exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, () -> "Log Cause Message ===> : "+exception.getMessage());
            JsfUtil.logRootCauseMessage(exception,context.getClass());
            throw new WebApplicationException(Response.status(400).build());
        }
    }
}