package edu.com.foodapi.persistence.repository;

import edu.com.foodapi.persistence.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
