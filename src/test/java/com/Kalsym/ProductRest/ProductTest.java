/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.ProductRest;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Kalsym
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {

    @Autowired
    private ProductRepository repository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateProduct() {
        Product product = new Product("iphone", 800);
        Product saveProduct = repository.save(product);
        assertNotNull(saveProduct);

    }

    @Test
    @Order(2)
    public void testFindProductByName() {
        String name = "iphone";
        Product product = repository.findByName(name);
        Assertions.assertThat(product.getName()).isEqualTo(name);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void testUpdateProduct() {
        String productName = "samsung";
        Product product = new Product(productName, 500);
        product.setId(1);
        repository.save(product);

        Product updatedProduct = repository.findByName(productName);
        Assertions.assertThat(updatedProduct.getName()).isEqualTo(productName);
    }

    @Test
    @Order(4)
    public void testListProducts() {
        List<Product> products = (List<Product>) repository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }

        Assertions.assertThat(products).size().isGreaterThan(0);

    }

    @Test
    @Order(5)
    public void testDeleteProduct() {
        Integer id = 1;
        boolean isPresentBeforeDelete = repository.findById(id).isPresent();

        repository.deleteById(id);

        boolean isPresentAfterDelete = repository.findById(id).isPresent();
        //   assertTrue(isPresentBeforeDelete);
        assertFalse(isPresentAfterDelete);

    }
}
