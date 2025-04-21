package edu.com.foodapi.persistence.repository;

import edu.com.foodapi.persistence.entity.Orderd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderdRepository extends JpaRepository<Orderd, Long> {
}
