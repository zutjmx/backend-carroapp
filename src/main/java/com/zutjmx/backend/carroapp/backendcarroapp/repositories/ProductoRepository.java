package com.zutjmx.backend.carroapp.backendcarroapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zutjmx.backend.carroapp.backendcarroapp.models.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    
}
