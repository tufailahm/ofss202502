package com.training.inheritDemos;

public class ProductPriceNegativeException extends RuntimeException{
    public ProductPriceNegativeException() {
    }

    public ProductPriceNegativeException(String message) {
        super(message);
    }

    public ProductPriceNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductPriceNegativeException(Throwable cause) {
        super(cause);
    }

    public ProductPriceNegativeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
