package com.webcodein.common.nonFunctionalRequirements.exceptionHandlers;


import com.webcodein.common.nonFunctionalRequirements.error.RestErrorResponse;
import com.webcodein.common.nonFunctionalRequirements.utils.GeneralUtil;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class WebServiceExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Throwable cause = GeneralUtil.getRootCause(new Exception(exception).getCause());
		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, cause);

		return Response.status(400).entity(new RestErrorResponse(exception.getMessage(),
				cause.getMessage().equalsIgnoreCase(exception.getMessage()) ? null : cause.getMessage())).build();
	}

}
