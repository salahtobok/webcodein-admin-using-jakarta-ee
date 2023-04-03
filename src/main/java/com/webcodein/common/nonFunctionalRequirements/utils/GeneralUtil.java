package com.webcodein.common.nonFunctionalRequirements.utils;


import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralUtil {

    public static Throwable getRootCause(Throwable cause) {
        if (cause != null) {
            Throwable source = cause.getCause();
            if (source != null) {
                return getRootCause(source);
            } else {
                return cause;
            }
        }
        return null;
    }
    public static Throwable logRootCauseMessage(Throwable cause, Class currentClass) {
        if (cause != null) {
            Throwable source = cause.getCause();
            if (source != null) {
                Logger.getLogger(currentClass.getSimpleName()).log(Level.SEVERE, () -> "Log Cause Message ===> : "+source.getMessage());
                return logRootCauseMessage(source,currentClass);
            } else {
                return cause;
            }
        }
        return null;
    }

}
