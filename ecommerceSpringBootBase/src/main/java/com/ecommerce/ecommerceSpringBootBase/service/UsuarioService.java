package com.ecommerce.ecommerceSpringBootBase.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.ecommerceSpringBootBase.model.Usuario;

public interface UsuarioService {
    Optional<Usuario> findById(Integer id);

    List<Usuario> findAll();
}