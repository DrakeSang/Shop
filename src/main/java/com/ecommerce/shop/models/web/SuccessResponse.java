package com.ecommerce.shop.models.web;


public class SuccessResponse extends WebResponse
{
    public SuccessResponse(Object responseBody)
    {
        super(ResponseStatus.SUCCESS, responseBody);
    }
}
