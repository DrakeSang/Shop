package com.ecommerce.shop.models.external.view;


import java.util.HashMap;
import java.util.Map;

/**
 * Category view model having map, which keeps category type as string and count of the products that category has.
 */
public class CategoryViewModel
{
    private Map<String, Long> categoriesMap;
    
    
    public CategoryViewModel()
    {
        this.categoriesMap = new HashMap<>();
    }
    
    
    public Map<String, Long> getCategoriesMap()
    {
        return categoriesMap;
    }
    
    
    public void setCategoriesMap(Map<String, Long> categoriesMap)
    {
        this.categoriesMap = categoriesMap;
    }
}
