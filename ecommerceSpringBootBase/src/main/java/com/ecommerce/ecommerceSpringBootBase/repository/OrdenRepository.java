package com.ecommerce.ecommerceSpringBootBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerceSpringBootBase.model.Orden;
import com.ecommerce.ecommerceSpringBootBase.model.Usuario;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByUsuario (Usuario usuario);
}
