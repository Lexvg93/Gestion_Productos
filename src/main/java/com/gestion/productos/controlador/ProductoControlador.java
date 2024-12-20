package com.gestion.productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.servicio.ProductoServicio;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return servicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obteneProducto(@PathVariable Integer id){
        try {
            Producto producto = servicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
            // TODO: handle exception
        }
        
    }


}
