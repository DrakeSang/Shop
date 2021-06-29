package com.ecommerce.shop.models.internal.product;


import com.ecommerce.shop.models.enums.CategoryType;

import java.time.LocalDate;

/**
 * Class for internal logic used on the service layer and having inside non primitive and primitive data types.
 */
public class ProductCreateServiceModel
{
    private String name;
    
    private CategoryType categoryType;
    
    private String description;
    
    private Long quantity;
    
    private LocalDate createdAt;
    
    private LocalDate updatedAt;
    
    
    public ProductCreateServiceModel(String name, CategoryType categoryType, String description, Long quantity,
            LocalDate createdAt, LocalDate updatedAt)
    {
        this.name = name;
        this.categoryType = categoryType;
        this.description = description;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public CategoryType getCategory()
    {
        return categoryType;
    }
    
    
    public void setCategory(CategoryType categoryType)
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
    
    
    public LocalDate getCreatedAt()
    {
        return createdAt;
    }
    
    
    public void setCreatedAt(LocalDate createdAt)
    {
        this.createdAt = createdAt;
    }
    
    
    public LocalDate getUpdatedAt()
    {
        return updatedAt;
    }
    
    
    public void setUpdatedAt(LocalDate updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
