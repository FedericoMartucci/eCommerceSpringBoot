package com.ecommerce.ecommerceSpringBootBase.repository;
import com.ecommerce.ecommerceSpringBootBase.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
}
