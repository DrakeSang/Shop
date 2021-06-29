package com.ecommerce.shop.controllers;


import com.ecommerce.shop.models.web.ErrorResponse;
import com.ecommerce.shop.models.web.SuccessResponse;
import com.ecommerce.shop.models.web.WebResponse;
import com.ecommerce.shop.services.purchase.PurchaseProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Rest controller responsible for order products from the shop.
 */
@RestController
@RequestMapping("/api/v1")
public class PurchaseApiController
{
    private static final String USER_MESSAGE = "userMessage";
    
    private final PurchaseProductService purchaseProductService;
    
    
    public PurchaseApiController(PurchaseProductService purchaseProductService)
    {
        this.purchaseProductService = purchaseProductService;
    }

    /**
     * Purchasing product.
     *
     * @param productId the id of the product to be purchased.
     * @param productQuantity the quantity of the product, which the user wants to buy.
     * @return object of type {@link WebResponse} with status(success or fail) and response body.
     */
    @PostMapping("/products/{id}/order/{quantity}")
    public ResponseEntity<WebResponse> purchaseProduct(@PathVariable(value = "id") long productId,
            @PathVariable(value = "quantity") long productQuantity)
    {
        if (productQuantity < 0)
        {
            return ResponseEntity.ok(new ErrorResponse(Map.of(
                    USER_MESSAGE, "Your order failed. Quantity of the product must be not negative number."
            )));
        }
        
        if (!purchaseProductService.isQuantityAvailableForProduct(productId, productQuantity))
        {
            return ResponseEntity.ok(new ErrorResponse(Map.of(
                    USER_MESSAGE, "Your order failed. We are sorry, but the quantity of the purchased product is "
                            + "great or less than we have available."
            )));
        }
        
        boolean isSuccessful = purchaseProductService.purchaseProduct(productId, productQuantity);
        
        if (!isSuccessful)
        {
            return ResponseEntity.ok(new ErrorResponse(Map.of(
                    USER_MESSAGE, "Your order failed. Please try again later or contact us."
            )));
        }
        
        return ResponseEntity.ok(new SuccessResponse(Map.of(
                USER_MESSAGE, "Your order of the product was successful."
        )));
    }
}
