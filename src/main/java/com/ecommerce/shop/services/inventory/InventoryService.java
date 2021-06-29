package com.ecommerce.shop.services.inventory;


import com.ecommerce.shop.models.external.binding.ProductFilterBindingModel;
import com.ecommerce.shop.models.internal.inventory.ProductsResponseByFilter;


/**
 * Service providing functionality for listing products.
 */
public interface InventoryService
{
    /**
     * Gets all products by the passed filter.
     *
     * @param filter object of type {@link ProductFilterBindingModel}, which inside has the name of the column to order
     * by, order direction(ASC or DESC), page number and page size
     * @return an object of ype {@link ProductsResponseByFilter} keeping inside teh object the total count of the products received
     * by the passed filter and list of them, which need to be shown
     */
    ProductsResponseByFilter getProductsByFilter(ProductFilterBindingModel filter);
}
