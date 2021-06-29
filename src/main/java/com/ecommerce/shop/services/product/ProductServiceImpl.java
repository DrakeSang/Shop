package com.ecommerce.shop.services.product;


import com.ecommerce.shop.models.external.view.ProductViewModel;
import com.ecommerce.shop.models.internal.product.ProductCreateServiceModel;
import com.ecommerce.shop.models.persistent.Product;
import com.ecommerce.shop.persistent.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    private final ProductRepository productRepository;
    
    
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    
    
    @Override
    public void insertProduct(ProductCreateServiceModel productCreateServiceModel)
    {
        Product product = new Product();
        product.setName(productCreateServiceModel.getName());
        product.setCategory(productCreateServiceModel.getCategory().getType());
        product.setDescription(productCreateServiceModel.getDescription());
        product.setQuantity(productCreateServiceModel.getQuantity());
        product.setCreatedAt(productCreateServiceModel.getCreatedAt());
        product.setUpdatedAt(productCreateServiceModel.getUpdatedAt());
        
        productRepository.save(product);
    }
    
    
    @Override
    public boolean updateProduct(long productId, ProductCreateServiceModel productCreateServiceModel)
    {
        Optional<Product> productBeforeUpdate = productRepository.findById(productId);
        
        if (productBeforeUpdate.isEmpty())
        {
            LOGGER.warn("Product not found with id {} on updating request", productId);
            return false;
        }
        
        Product product = productBeforeUpdate.get();
        product.setQuantity(productCreateServiceModel.getQuantity());
        product.setUpdatedAt(LocalDate.now());
        
        productRepository.save(product);
        
        return true;
    }
    
    
    @Override
    public boolean deleteProduct(long productId)
    {
        Optional<Product> productBeforeDelete = productRepository.findById(productId);
        
        if (productBeforeDelete.isEmpty())
        {
            LOGGER.warn("Product not found with id {} on deleting request", productId);
            return false;
        }
        
        Product product = productBeforeDelete.get();
        productRepository.delete(product);
        
        return true;
    }


    @Override
    public ProductViewModel getProductById(long productId)
    {
        Optional<Product> productFromDb = productRepository.findById(productId);

        if (productFromDb.isEmpty())
        {
            LOGGER.warn("Product not found with id {} on getting single product", productId);
            return null;
        }

        Product product = productFromDb.get();

        return new ProductViewModel(
                product.getName(), product.getCategory(), product.getDescription(), product.getQuantity());
    }
}
