package com.ecommerce.shop.models.internal.category;


import com.ecommerce.shop.models.enums.CategoryType;
import com.ecommerce.shop.models.external.view.CategoryViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Category object having map, which keeps as key object of type {@link CategoryType} and count of the products
 * that category has.
 */
public class CategoryResponse
{
    private Map<CategoryType, Long> productsCountByCategory;
    
    
    public CategoryResponse()
    {
        this.productsCountByCategory = new HashMap<>();
    }
    
    
    public Map<CategoryType, Long> getProductsCountByCategory()
    {
        return productsCountByCategory;
    }
    
    
    public void setProductsCountByCategory(Map<CategoryType, Long> productsCountByCategory)
    {
        this.productsCountByCategory = productsCountByCategory;
    }
    
    
    public CategoryViewModel toExternal()
    {
        CategoryViewModel categoryViewModel = new CategoryViewModel();
        
        for (Map.Entry<CategoryType, Long> entry : productsCountByCategory.entrySet())
        {
            categoryViewModel.getCategoriesMap().put(entry.getKey().getType(), entry.getValue());
        }
        
        return categoryViewModel;
    }
}
