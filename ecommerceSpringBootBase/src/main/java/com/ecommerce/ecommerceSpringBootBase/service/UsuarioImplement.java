package com.ecommerce.ecommerceSpringBootBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceSpringBootBase.model.Usuario;
import com.ecommerce.ecommerceSpringBootBase.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImplement implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}