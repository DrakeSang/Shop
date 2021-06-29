package com.ecommerce.shop.persistent.category;


import com.ecommerce.shop.models.persistent.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductsByCategoryRepository extends JpaRepository<Product, Long>
{
    @Query(value = "SELECT DISTINCT p.category, COUNT(*) as test "+
            "FROM products AS p "+
            "GROUP BY category " +
            "ORDER BY test ASC ", nativeQuery = true)
    List<Object[]> countTotalProductsByCategory();
}
