package com.ecommerce.shop.services.category;


import com.ecommerce.shop.models.internal.category.CategoryResponse;


public interface CategoryService
{
    /**
     * Gets total count of products for each category.
     *
     * @return object of type {@link CategoryResponse}.
     */
    CategoryResponse getTotalProductsByCategory();
}
