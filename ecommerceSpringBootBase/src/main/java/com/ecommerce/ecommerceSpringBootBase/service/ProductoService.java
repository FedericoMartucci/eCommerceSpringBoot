package com.ecommerce.ecommerceSpringBootBase.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerceSpringBootBase.model.Producto;

public interface ProductoService {
	public Producto create(Producto producto);
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	public List<Producto> findAll();
}
