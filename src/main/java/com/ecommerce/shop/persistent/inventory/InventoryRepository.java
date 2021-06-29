package com.ecommerce.shop.persistent.inventory;


import com.ecommerce.shop.models.persistent.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Product, Long>
{
}
