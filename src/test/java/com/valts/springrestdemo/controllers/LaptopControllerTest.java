package com.valts.springrestdemo.controllers;

import com.valts.springrestdemo.entities.Laptop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LaptopControllerTest {

//    TODO finish tests

    private TestRestTemplate testRestTemplate;

    @DisplayName("Should get list of all laptops")
    @Test
    void getLaptops() {
        ResponseEntity response = testRestTemplate.getForEntity("/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getLaptopById() {
    }

    @Test
    void postLaptop() {
    }

    @Test
    void updateLaptop() {
    }

    @Test
    void deleteAllLaptops() {
    }

    @Test
    void deleteLaptopById() {
    }
}