package com.ecommerce.shop.services.purchase;


import com.ecommerce.shop.models.persistent.Product;
import com.ecommerce.shop.persistent.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class PurchaseProductServiceImp implements PurchaseProductService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseProductServiceImp.class);
    
    private final ProductRepository productRepository;
    
    
    public PurchaseProductServiceImp(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    
    
    @Override public boolean purchaseProduct(long productId, long quantity)
    {
        Optional<Product> productFromDB = productRepository.findById(productId);
        
        if (productFromDB.isEmpty())
        {
            LOGGER.warn("Product not found with id {} on making purchase.", productId);
            return false;
        }
    
        Product product = productFromDB.get();
        product.setQuantity(product.getQuantity() - quantity);
        product.setUpdatedAt(LocalDate.now());
    
        productRepository.save(product);
        
        return true;
    }
    
    
    @Override public boolean isQuantityAvailableForProduct(long productId, long quantity)
    {
        Optional<Product> productFromDB = productRepository.findById(productId);
    
        long productQuantityBeforePurchase = productFromDB.get().getQuantity();
        return productQuantityBeforePurchase >= quantity;
    }
}
