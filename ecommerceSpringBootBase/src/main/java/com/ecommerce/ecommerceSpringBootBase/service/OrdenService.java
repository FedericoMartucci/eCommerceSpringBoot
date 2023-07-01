package com.ecommerce.ecommerceSpringBootBase.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerceSpringBootBase.model.Orden;
import com.ecommerce.ecommerceSpringBootBase.model.Usuario;

public interface OrdenService {
    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);
}
