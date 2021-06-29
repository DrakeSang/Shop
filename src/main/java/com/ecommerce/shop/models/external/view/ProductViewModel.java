package com.ecommerce.shop.models.external.view;

/**
 * Product view model having only primitive data types.
 */
public class ProductViewModel
{
    private String name;
    
    private String categoryType;
    
    private String description;
    
    private Long quantity;


    public ProductViewModel()
    {

    }
    
    
    public ProductViewModel(String name, String categoryType, String description, Long quantity)
    {
        this.name = name;
        this.categoryType = categoryType;
        this.description = description;
        this.quantity = quantity;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public String getCategoryType()
    {
        return categoryType;
    }
    
    
    public void setCategoryType(String categoryType)
    {
        this.categoryType = categoryType;
    }
    
    
    public String getDescription()
    {
        return description;
    }
    
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    
    public Long getQuantity()
    {
        return quantity;
    }
    
    
    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }
}