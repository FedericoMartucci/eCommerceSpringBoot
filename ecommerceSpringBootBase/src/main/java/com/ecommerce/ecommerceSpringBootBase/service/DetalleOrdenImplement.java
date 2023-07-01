package com.ecommerce.ecommerceSpringBootBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceSpringBootBase.model.DetalleOrden;
import com.ecommerce.ecommerceSpringBootBase.repository.DetalleOrdenRepository;

@Service
public class DetalleOrdenImplement implements DetalleOrdenService {
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
}
