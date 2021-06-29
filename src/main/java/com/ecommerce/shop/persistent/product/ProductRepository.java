package com.ecommerce.shop.persistent.product;


import com.ecommerce.shop.models.persistent.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>
{

}
