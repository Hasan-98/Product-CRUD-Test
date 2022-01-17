/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.ProductRest;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Kalsym
 */
@WebMvcTest(ProductController.class)
@WebAppConfiguration
@ContextConfiguration
public class ProductTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public WebApplicationContext webApplicationContext;

    private static ObjectMapper mapper = new ObjectMapper();

    @MockBean
    ProductService productService;

    @BeforeTestMethod
    public void setUp() {

    }

    @Test
    public void addProductTest() throws Exception {
        Product p = new Product("Keyboard", 300);
        String jsonRequest = mapper.writeValueAsString(p);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductTest() throws Exception {
        Product p = new Product("Keyboard", 300);
        String jsonRequest = mapper.writeValueAsString(p);

        mockMvc.perform(get("/products/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProductTest() throws Exception {
        Product p = new Product("Keyboard", 300);

        String jsonRequest = mapper.writeValueAsString(p);

        mockMvc.perform(delete("/products/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    public void postProductTest() throws Exception {
        Product p = new Product("Mouse", 300);
        String jsonRequest = mapper.writeValueAsString(p);

        mockMvc.perform(put("/products/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk());
    }

}
