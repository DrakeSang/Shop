package com.ecommerce.shop.controllers;


import com.ecommerce.shop.models.external.binding.ProductCreateBindingModel;
import com.ecommerce.shop.models.external.view.ProductViewModel;
import com.ecommerce.shop.models.web.ErrorResponse;
import com.ecommerce.shop.models.web.SuccessResponse;
import com.ecommerce.shop.models.web.WebResponse;
import com.ecommerce.shop.services.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


/**
 * Rest controller responsible for working with products providing crud functionality(create, update, delete).
 */
@RestController
@RequestMapping("/api/v1")
public class ProductApiController
{
    private static final String USER_MESSAGE = "userMessage";
    
    private final ProductService productService;
    
    
    public ProductApiController(ProductService productService)
    {
        this.productService = productService;
    }
    
    
    /**
     * Insert product.
     *
     * @param productRequestModel object of type {@link ProductCreateBindingModel}
     * @return object of type {@link WebResponse} with status(success or fail) and response body
     */
    @PostMapping("/products/create")
    public ResponseEntity<WebResponse> insertProduct(@Valid @RequestBody ProductCreateBindingModel productRequestModel,
            BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return ResponseEntity.ok(new ErrorResponse(bindingResult.getFieldErrors()));
        }
        
        productService.insertProduct(productRequestModel.toInternal());
        
        return ResponseEntity.ok(new SuccessResponse(productRequestModel));
    }
    
    
    /**
     * Update product.
     *
     * @param productId the product id.
     * @return object of type {@link WebResponse} with status(success or fail) and response body
     */
    @PutMapping("/products/update/{id}")
    public ResponseEntity<WebResponse> updateProduct(@PathVariable(value = "id") long productId,
            @Valid @RequestBody ProductCreateBindingModel productRequestModel, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return ResponseEntity.ok(new ErrorResponse(bindingResult.getFieldErrors()));
        }
        
        boolean isSuccessful = productService.updateProduct(productId, productRequestModel.toInternal());
        
        if (!isSuccessful)
        {
            return ResponseEntity.ok(new ErrorResponse(Map.of(
                    USER_MESSAGE, "Updating the product failed. Please try again later or contact us."
            )));
        }
        
        return ResponseEntity.ok(new SuccessResponse(productRequestModel));
    }
    
    
    /**
     * Delete product.
     *
     * @param productId the product id.
     * @return object of type {@link WebResponse} with status(success or fail) and response body
     */
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<WebResponse> deleteProduct(@PathVariable(value = "id") long productId)
    {
        boolean isSuccessful = productService.deleteProduct(productId);
        
        if (!isSuccessful)
        {
            return ResponseEntity.ok(new ErrorResponse(Map.of(
                    USER_MESSAGE, "Updating the product failed. Please try again later or contact us."
            )));
        }
        
        return ResponseEntity.ok(new SuccessResponse(Map.of(
                USER_MESSAGE, "Deleting the product was successful"
        )));
    }

    @GetMapping("/products/get/{id}")
    public ProductViewModel getSingleProduct(@PathVariable(value = "id") long productId)
    {
        return productService.getProductById(productId);
    }
}
