package com.ecommerce.shop.services.product;


import com.ecommerce.shop.models.external.view.ProductViewModel;
import com.ecommerce.shop.models.internal.product.ProductCreateServiceModel;


/**
 * Service providing functionality for working with product data. It may add, update or delete data from repository.
 */
public interface ProductService
{
    /**
     * Insert new product by the provided internal object into the database.
     *
     * @param productCreateServiceModel the product to be inserted.
     */
    void insertProduct(ProductCreateServiceModel productCreateServiceModel);
    
    /**
     * Update product by the provided internal object.
     *
     * @param productId the id of the product, which needs to be updated.
     * @param productCreateServiceModel the new product.
     * @return true if the product was updated successfully, otherwise false if the product could not be found by the
     * passed id
     */
    boolean updateProduct(long productId, ProductCreateServiceModel productCreateServiceModel);
    
    /**
     * Delete product from persistent layer.
     *
     * @param productId the id of the product, which needs to be deleted.
     * @return true if the product was deleted successfully, otherwise false if the product could not be found by the
     * passed id
     */
    boolean deleteProduct(long productId);

    /**
     * Get single product.
     *
     * @param productId the id of the product, which to be searched for.
     * @return object of type {@link ProductViewModel}.
     */
    ProductViewModel getProductById(long productId);
}
