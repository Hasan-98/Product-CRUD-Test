package com.Kalsym.ProductRest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRestApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductController controller;

    @Test
    public void testSaveNewProduct() {
   //     entityManager.persist(new Product(10 , "iPhone10" , 2000));

    //    Product product = controller.get(10);

       /// assertThat(product.getName()).isEqualTo("iPhone 10");
    }
}
