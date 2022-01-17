/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.ProductRest;

import java.nio.file.Files;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hasan
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

//    @GetMapping("/products")
//    public List<Product> list() {
//        return service.listAll();
//    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable int id) {
        try {
            Product product = service.Update(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public Product add(@RequestBody Product product) {
        service.save(product);
        return product;

    }
//    @PostMapping("/products")
//    public Response addProduct(@RequestBody Product product) {
//        service.save(product);
//        return new Response(product.getId() + " inserted", Boolean.TRUE);
//    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable int id) {
        return new ResponseEntity<Product>(service.UpdateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
