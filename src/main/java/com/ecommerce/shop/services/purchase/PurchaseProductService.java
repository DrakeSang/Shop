package com.ecommerce.shop.services.purchase;


public interface PurchaseProductService
{
    /**
     * Purchasing product and updates it's quantity.
     *
     * @param productId the id of the product to be updated.
     * @param quantity the quantity of the product, which wants to be bought.
     * @return true if the product was purchased, otherwise false if product id is incorrect.
     */
    boolean purchaseProduct(long productId, long quantity);
    
    /**
     * Checks if the quantity of the desired product is available.
     *
     * @param productId the id of the product to be checked.
     * @param quantity the quantity of the product, which wants to be bought.
     * @return true if the passed quantity is available, otherwise false if it is not available.
     */
    boolean isQuantityAvailableForProduct(long productId, long quantity);
}
