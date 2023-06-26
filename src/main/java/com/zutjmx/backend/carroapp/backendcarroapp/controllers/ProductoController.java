package com.zutjmx.backend.carroapp.backendcarroapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.zutjmx.backend.carroapp.backendcarroapp.models.entities.Producto;
import com.zutjmx.backend.carroapp.backendcarroapp.services.ProductoService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/genera/{cuantos}")
    public String generaDatos(@PathVariable int cuantos) {
        Faker faker = new Faker();
        for (int i = 0; i < cuantos; i++) {
            Producto producto = new Producto();
            producto.setNombre(faker.commerce().productName());
            producto.setDescripcion(faker.lorem().paragraph());
            producto.setPrecio(faker.number().randomNumber(3, false));
            //producto.setPrecio(Long.parseLong(faker.commerce().price()));
            productoService.save(producto);
        }
        return "Ok";
    }
}
