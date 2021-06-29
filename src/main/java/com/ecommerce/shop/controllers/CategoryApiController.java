package com.ecommerce.shop.controllers;


import com.ecommerce.shop.models.external.view.CategoryViewModel;
import com.ecommerce.shop.models.internal.category.CategoryResponse;
import com.ecommerce.shop.models.web.SuccessResponse;
import com.ecommerce.shop.models.web.WebResponse;
import com.ecommerce.shop.services.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Rest controller responsible for working with categories like getting products count by it's category, etc...
 */
@RestController
@RequestMapping("/api/v1")
public class CategoryApiController
{
    private final CategoryService categoryService;
    
    
    public CategoryApiController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    /**
     * Get products count for each category
     *
     * @return object of type {@link WebResponse} with status and response body
     */
    @GetMapping("/categories")
    public ResponseEntity<WebResponse> productsCountByCategory()
    {
        CategoryResponse productsCountByCategory = categoryService.getTotalProductsByCategory();
        
        CategoryViewModel response = productsCountByCategory.toExternal();
        
        return ResponseEntity.ok(new SuccessResponse(Map.of(
                "response", response)));
    }
}
