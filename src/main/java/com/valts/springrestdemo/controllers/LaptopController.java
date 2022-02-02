package com.valts.springrestdemo.controllers;

import com.valts.springrestdemo.entities.Laptop;
import com.valts.springrestdemo.repos.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;


//@Controller
@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    public ResponseEntity getLaptops() {
        return ResponseEntity.ok().body(laptopRepository.findAll());
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity getLaptopById(@PathVariable Long id) {
        Optional<Laptop> optional = laptopRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/laptops")
    public ResponseEntity postLaptop(@RequestBody Laptop laptop) {
        Laptop savedLaptop = laptopRepository.save(laptop);
        return ResponseEntity.ok(savedLaptop);
    }

    @PutMapping("/laptops/{id}")
    public ResponseEntity updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Laptop> optional = laptopRepository.findById(id);

        if (optional.isPresent()) {
            Laptop updatedLaptop = laptopRepository.save(laptop);
            return ResponseEntity.ok(updatedLaptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/laptops")
    public ResponseEntity deleteAllLaptops() {
        laptopRepository.deleteAll();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity deleteLaptopById(@PathVariable() Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isPresent()) {
            laptopRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
