package com.ecommerce.shop.models.external.binding;


import com.ecommerce.shop.models.enums.CategoryType;
import com.ecommerce.shop.models.internal.product.ProductCreateServiceModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Binding model on creating/updating product received from the request.
 */
public class ProductCreateBindingModel
{
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    private String name;
    
    private String category;
    
    private String description;
    
    private Long quantity;
    
    private String createdAt;
    
    private String updatedAt;
    
    
    public ProductCreateBindingModel()
    {
    
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    public String getCategory()
    {
        return category;
    }
    
    
    public void setCategory(String category)
    {
        this.category = category;
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
    
    
    public String getCreatedAt()
    {
        return createdAt;
    }
    
    
    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }
    
    
    public String getUpdatedAt()
    {
        return updatedAt;
    }
    
    
    public void setUpdatedAt(String updatedAt)
    {
        this.updatedAt = updatedAt;
    }
    
    
    public ProductCreateServiceModel toInternal()
    {
        return new ProductCreateServiceModel(
                this.name,
                this.category != null ? CategoryType.ofType(this.category) : null,
                this.description,
                this.quantity,
                this.createdAt != null ? extractDate(this.createdAt) : null,
                this.updatedAt != null ? extractDate(this.updatedAt) : null
        );
    }
    
    
    private LocalDate extractDate(String date)
    {
        return LocalDate.parse(date, DTF);
    }
}
