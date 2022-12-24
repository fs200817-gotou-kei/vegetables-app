package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vegetable;
import com.example.demo.service.VegetableService;;

@RestController
@CrossOrigin()
@RequestMapping("/vegetables")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/list")
    public ResponseEntity<List<Vegetable>> getAll(@RequestParam(required = false) String name) {
        // TODO:
        // javaカリキュラムやってた時そうだったけど確か内部でエラー出てもちゃんと元の所にthrowされてた気がするからserviceでcatchしなくていい気がする
        try {
            List<Vegetable> resultVegetableList = this.vegetableService.getAll(name);
            if (resultVegetableList != null)
                return new ResponseEntity<>(resultVegetableList, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vegetable> create(@RequestBody Vegetable vegetable) {
        try {
            Vegetable resultVegetable = this.vegetableService.create(vegetable);
            return new ResponseEntity<>(resultVegetable, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
