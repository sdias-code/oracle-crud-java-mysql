package com.sdias.nutricionista.rest.exception;

public class NutricionistaNotFoundException extends Exception{

    public NutricionistaNotFoundException() {
        super();
    }

    public NutricionistaNotFoundException(String message) {
        super(message);
    }

    public NutricionistaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NutricionistaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected NutricionistaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
