/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Kalsym.ProductRest;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hasan
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Product findByName(String name);
}
