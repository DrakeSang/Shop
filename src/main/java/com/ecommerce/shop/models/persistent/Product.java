package com.ecommerce.shop.models.persistent;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "category", nullable = false)
    private String category;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDate createdAt;
    
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDate updatedAt;
    
    
    public Product()
    {
    
    }
    
    
    public long getId()
    {
        return id;
    }
    
    
    public void setId(long id)
    {
        this.id = id;
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
