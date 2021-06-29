package com.ecommerce.shop.controllers;


import com.ecommerce.shop.models.external.binding.ProductFilterBindingModel;
import com.ecommerce.shop.models.external.view.ProductViewModel;
import com.ecommerce.shop.models.internal.inventory.ProductsResponseByFilter;
import com.ecommerce.shop.models.web.ErrorResponse;
import com.ecommerce.shop.models.web.SuccessResponse;
import com.ecommerce.shop.models.web.WebResponse;
import com.ecommerce.shop.services.inventory.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * Rest controller responsible for listing operations on products with sorting options and pagination.
 */
@RestController
@RequestMapping("/api/v1")
public class InventoryApiController
{
    private final InventoryService inventoryService;
    
    
    public InventoryApiController(InventoryService inventoryService)
    {
        this.inventoryService = inventoryService;
    }

    /**
     * Get all products by given filter having column name direction and order direction
     *
     * @param productFilter object of type {@link ProductFilterBindingModel}
     * @param bindingResult the binding result keeping if the passed model from request has errors
     * @return object of type {@link WebResponse} with status and response body
     */
    @PostMapping("/products")
    public ResponseEntity<WebResponse> getProducts(@Valid @RequestBody ProductFilterBindingModel productFilter,
            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return ResponseEntity.ok(new ErrorResponse(bindingResult.getFieldErrors()));
        }
        
        ProductsResponseByFilter productsResponse = inventoryService.getProductsByFilter(productFilter);
    
        List<ProductViewModel> response = productsResponse.toExternal();
    
        return ResponseEntity.ok(new SuccessResponse(Map.of(
                "totalCount", productsResponse.getTotalCount(),
                "itemsForPage", response)));
    }
}
