package com.ecommerce.shop.models.web;


/**
 * A wrapper class of the http response, returned in ResponseEntity.
 */
public abstract class WebResponse
{
    enum ResponseStatus
    {
        SUCCESS,
        FAIL
    }
    
    
    private final ResponseStatus status;
    
    private final Object body;
    
    
    protected WebResponse(ResponseStatus status, Object body)
    {
        this.status = status;
        this.body = body;
    }
    
    
    public ResponseStatus getStatus()
    {
        return status;
    }
    
    
    public Object getBody()
    {
        return body;
    }
}
