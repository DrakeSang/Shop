package com.ecommerce.shop.services.inventory;


import com.ecommerce.shop.models.enums.CategoryType;
import com.ecommerce.shop.models.external.binding.ProductFilterBindingModel;
import com.ecommerce.shop.models.internal.inventory.ProductInventory;
import com.ecommerce.shop.models.internal.inventory.ProductsResponseByFilter;
import com.ecommerce.shop.models.persistent.Product;
import com.ecommerce.shop.persistent.inventory.InventoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService
{
    private final InventoryRepository inventoryRepository;
    
    
    public InventoryServiceImpl(InventoryRepository inventoryRepository)
    {
        this.inventoryRepository = inventoryRepository;
    }
    
    
    @Override public ProductsResponseByFilter getProductsByFilter(ProductFilterBindingModel filter)
    {
        List<Product> productsFromDB = inventoryRepository.findAll(
                "ASC".equals(filter.getOrderDirection()) ? Sort.by(Sort.Direction.ASC, filter.getOrderByColumnName()) :
                        Sort.by(Sort.Direction.DESC, filter.getOrderByColumnName()));
        
        List<ProductInventory> products = new ArrayList<>();
        for (Product currentProduct : productsFromDB)
        {
            ProductInventory productInventory = new ProductInventory(currentProduct.getName(),
                    CategoryType.valueOf(currentProduct.getCategory().toUpperCase()), currentProduct.getDescription(),
                    currentProduct.getQuantity());
            products.add(productInventory);
        }
        
        int totalCount = products.size();
        int startIndex = filter.getPageNumber() * filter.getPageSize();
        int endIndex = (filter.getPageNumber() + 1) * filter.getPageSize();
        
        return new ProductsResponseByFilter(totalCount,
                products.subList(Math.max(0, startIndex), Math.min(totalCount, endIndex)));
    }
}
