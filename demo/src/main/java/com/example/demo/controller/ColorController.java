package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Color;
import com.example.demo.service.ColorService;

@RestController
@CrossOrigin()
@RequestMapping("/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("/{id}")
    public ResponseEntity<Color> getById(@PathVariable long id) {
        try {
            Optional<Color> resultColor = this.colorService.getById(id);
            if (resultColor.isPresent()) {
                return new ResponseEntity<>(resultColor.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Color> create(@RequestBody Color color) {
        try {
            Color resultColor = this.colorService.create(color);
            return new ResponseEntity<>(resultColor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
