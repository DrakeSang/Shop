package com.ecommerce.shop.controllers.api;

import com.ecommerce.shop.controllers.api.base.ApiTestBase;
import com.ecommerce.shop.models.external.binding.ProductCreateBindingModel;
import com.ecommerce.shop.models.external.view.ProductViewModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class ProductApiTest extends ApiTestBase
{
    @Test
    public void testCreateProduct()
    {
        ProductCreateBindingModel createBindingModel = new ProductCreateBindingModel();
        createBindingModel.setName("LOGITECH CRAFT");
        createBindingModel.setCategory("Keyboard");
        createBindingModel.setDescription("Craft is a wireless keyboard with a premium typing experience and a " +
                "versatile input dial that adapts to what you’re making — keeping you focused and in your creative " +
                "flow.");
        createBindingModel.setQuantity(20L);
        createBindingModel.setCreatedAt("2020-09-10");
        createBindingModel.setUpdatedAt("2020-09-10");

        ResponseEntity<ProductCreateBindingModel> postResponse = getRestTemplate().postForEntity(
                getRootUrl() + "/api/v1/products/create",
                createBindingModel,
                ProductCreateBindingModel.class);

        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateProduct()
    {
        long productId = 3;

        // Update product
        ProductCreateBindingModel createBindingModel = new ProductCreateBindingModel();
        createBindingModel.setQuantity(26L);

        getRestTemplate().put(
                getRootUrl() + "/api/v1/products/update/" + productId,
                createBindingModel,
                ProductCreateBindingModel.class);

        // Get product by id and check his quantity
        ProductViewModel productAfterUpdate = getRestTemplate().getForObject(
                getRootUrl() + "/api/v1/products/get/" + productId,
                ProductViewModel.class);

        Assert.assertNotNull(productAfterUpdate);
        Assert.assertEquals(createBindingModel.getQuantity(), productAfterUpdate.getQuantity());
    }

    @Test
    public void testDeletedProduct()
    {
        long productId = 1;

        getRestTemplate().delete(getRootUrl() + "/api/v1/products/delete/" + productId);

        // Get product by the id and check is it deleted
        ProductViewModel productViewModel = getRestTemplate().getForObject(
                getRootUrl() + "/api/v1/products/get/" + productId,
                ProductViewModel.class);

        Assert.assertNull(productViewModel);
    }
}
