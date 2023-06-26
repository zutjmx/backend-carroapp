package com.zutjmx.backend.carroapp.backendcarroapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zutjmx.backend.carroapp.backendcarroapp.models.entities.Producto;
import com.zutjmx.backend.carroapp.backendcarroapp.services.ProductoService;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }
}
