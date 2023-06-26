package com.zutjmx.backend.carroapp.backendcarroapp.services;

import java.util.List;
import java.util.Optional;

import com.zutjmx.backend.carroapp.backendcarroapp.models.entities.Producto;

public interface ProductoService {
    List<Producto> findAll();    
    Optional<Producto>  findById(Long id);
    void save(Producto producto);
    void delete(Long id);
}
