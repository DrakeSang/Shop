package com.ecommerce.shop.models.internal.inventory;


import com.ecommerce.shop.models.external.view.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class keeping the total count of the products and list with objects of type {@link ProductInventory}.
 *
 */
public class ProductsResponseByFilter
{
    private long totalCount;
    
    private List<ProductInventory> productsInventoryList;
    
    
    public ProductsResponseByFilter(long totalCount, List<ProductInventory> productsInventoryList)
    {
        this.totalCount = totalCount;
        this.productsInventoryList = productsInventoryList;
    }
    
    
    public long getTotalCount()
    {
        return totalCount;
    }
    
    
    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }
    
    
    public List<ProductInventory> getProductsInventoryList()
    {
        return productsInventoryList;
    }
    
    
    public void setProductsInventoryList(List<ProductInventory> productsInventoryList)
    {
        this.productsInventoryList = productsInventoryList;
    }
    
    
    public List<ProductViewModel> toExternal()
    {
        List<ProductViewModel> result = new ArrayList<>();
        for (ProductInventory product : productsInventoryList)
        {
            final ProductViewModel productViewModel = new ProductViewModel(product.getName(),
                    product.getCategoryType().getType(), product.getDescription(), product.getQuantity());
            result.add(productViewModel);
        }
        
        return result;
    }
}
