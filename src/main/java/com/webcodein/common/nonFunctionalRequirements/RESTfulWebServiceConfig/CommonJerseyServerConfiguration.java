package com.webcodein.common.nonFunctionalRequirements.RESTfulWebServiceConfig;

import com.webcodein.common.nonFunctionalRequirements.exceptionHandlers.WebServiceExceptionHandler;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


/** This is applicable only when request enter and exit from server side
 *  ( Lifecycle of the treatment Java EE // Jakarta EE client is not mentioned )
 * Client Request Initiated → Client Request Filters → Client Writer Interceptors →
 * Client MessageBodyWriter → Server → Client Response Filters →
 * Client Reader Interceptors → Client MessageBodyReader → Client Receives the Response
 */
@ApplicationPath("/api/v1/common")
public class CommonJerseyServerConfiguration extends ResourceConfig {
    public CommonJerseyServerConfiguration() {
        // 01 - PempPreMatchRequestFilter
        //register(new PempPreMatchRequestFilter());
        // 02 - PempPostMatchRequestFilter
        //register(new PempPostMatchRequestFilter());
        // 03 - PempReaderInterceptor
        //register(new PempReaderInterceptor());
        // 04 - PempPreMatchResponseFilter
        //register(new PempPreMatchResponseFilter());
        // 05 - PempPostMatchResponseFilter
        //register(new PempPostMatchResponseFilter());
        // 06 - PempWriterInterceptor
        //register(new PempWriterInterceptor());

        register(WebServiceExceptionHandler.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);

        packages("com.webcodein.common.functionalRequirements.restResource");

    }

}
