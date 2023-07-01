package com.ecommerce.ecommerceSpringBootBase.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerceSpringBootBase.model.Producto;

public interface ProductoService {
	Producto create(Producto producto);
	Optional<Producto> get(Integer id);
	void update(Producto producto);
	void delete(Integer id);
	void save(Producto producto);
	List<Producto> findAll();
}
