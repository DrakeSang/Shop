package com.ecommerce.shop.models.external.binding;


/**
 * Binding model on filtering products received from the request.
 */
public class ProductFilterBindingModel
{
    private String orderByColumnName;
    
    private String orderDirection;
    
    private int pageNumber;
    
    private int pageSize;
    
    
    public ProductFilterBindingModel()
    {
    }
    
    
    public String getOrderByColumnName()
    {
        return orderByColumnName;
    }
    
    
    public void setOrderByColumnName(String orderByColumnName)
    {
        this.orderByColumnName = orderByColumnName;
    }
    
    
    public String getOrderDirection()
    {
        return orderDirection;
    }
    
    
    public void setOrderDirection(String orderDirection)
    {
        this.orderDirection = orderDirection;
    }
    
    
    public int getPageNumber()
    {
        return pageNumber;
    }
    
    
    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }
    
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}
