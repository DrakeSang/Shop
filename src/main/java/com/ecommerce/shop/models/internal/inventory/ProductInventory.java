package com.ecommerce.shop.models.internal.inventory;


import com.ecommerce.shop.models.enums.CategoryType;

/**
 * Inventory class describing product.
 */
public class ProductInventory
{
    private String name;
    
    private CategoryType categoryType;
    
    private String description;
    
    private Long quantity;
    
    
    public ProductInventory(String name, CategoryType categoryType, String description, Long quantity)
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
    
    
    public CategoryType getCategoryType()
    {
        return categoryType;
    }
    
    
    public String getDescription()
    {
        return description;
    }
    
    
    public Long getQuantity()
    {
        return quantity;
    }
}
