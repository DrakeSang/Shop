package com.ecommerce.shop.models.web;


public class ErrorResponse extends WebResponse
{
    public ErrorResponse(Object responseBody)
    {
        super(ResponseStatus.FAIL, responseBody);
    }
}
