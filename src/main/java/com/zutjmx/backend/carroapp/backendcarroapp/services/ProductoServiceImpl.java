package com.zutjmx.backend.carroapp.backendcarroapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.zutjmx.backend.carroapp.backendcarroapp.models.entities.Producto;
import com.zutjmx.backend.carroapp.backendcarroapp.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        // TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(Producto producto) {
        // TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) {
        // TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Transactional
    public void generaDatos(Long cuantos) {
        Faker faker = new Faker();
        for (int i = 0; i < cuantos; i++) {
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setDescripcion(faker.company().buzzword());
            producto.setPrecio(faker.number().randomNumber(2, false));
            productoRepository.save(producto);
        }
    }
    
}
