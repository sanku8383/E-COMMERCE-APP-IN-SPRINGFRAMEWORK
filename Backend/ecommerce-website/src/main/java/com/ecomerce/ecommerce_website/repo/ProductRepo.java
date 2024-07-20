package com.ecomerce.ecommerce_website.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecomerce.ecommerce_website.model.Product;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

    @Query("SELECT p from Product p WHERE" +
                        "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword, '%')) OR "+
                        "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword, '%')) OR" +
                        "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword, '%')) OR " +
                        "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword, '%')) OR "
                                           )
    List<Product> searchProduct(String keyword);
}
