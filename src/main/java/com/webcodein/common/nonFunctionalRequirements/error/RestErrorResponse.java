package com.webcodein.common.nonFunctionalRequirements.error;

public class RestErrorResponse {
    private Object subject;
    private String message;

    private String rootMessage;


    public RestErrorResponse() {
    }

    public RestErrorResponse(String message) {
        this.message = message;
    }



    public RestErrorResponse(String message, String causeMessage) {
        this.message = message;
        this.rootMessage = causeMessage;
    }


    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRootMessage() {
        return rootMessage;
    }

    public void setRootMessage(String rootMessage) {
        this.rootMessage = rootMessage;
    }
}
