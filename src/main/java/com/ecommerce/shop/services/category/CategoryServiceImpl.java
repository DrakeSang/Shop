package com.ecommerce.shop.services.category;


import com.ecommerce.shop.models.enums.CategoryType;
import com.ecommerce.shop.models.internal.category.CategoryResponse;
import com.ecommerce.shop.persistent.category.ProductsByCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService
{
    private final ProductsByCategoryRepository productsByCategoryRepository;
    
    
    public CategoryServiceImpl(ProductsByCategoryRepository productsByCategoryRepository)
    {
        this.productsByCategoryRepository = productsByCategoryRepository;
    }
    
    
    @Override public CategoryResponse getTotalProductsByCategory()
    {
        List<Object[]> productsCountyCategory = productsByCategoryRepository.countTotalProductsByCategory();
        
        CategoryResponse categoryResponse = new CategoryResponse();
        for (Object[] object : productsCountyCategory)
        {
            CategoryType categoryType = CategoryType.valueOf(((String) object[0]).toUpperCase());
            Long count = Long.valueOf(object[1].toString());
            
            categoryResponse.getProductsCountByCategory().put(categoryType, count);
        }
        
        return categoryResponse;
    }
}
