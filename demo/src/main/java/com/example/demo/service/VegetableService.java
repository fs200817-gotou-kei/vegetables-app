package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vegetable;
import com.example.demo.repository.VegetableRepository;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public List<Vegetable> getAll(String name) {
        try {
            if (name == null)
                return this.vegetableRepository.findAll();
            return this.vegetableRepository.findByNameContaining(name);
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<Vegetable> getById(long id) {
        try {
            return this.vegetableRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Vegetable create(Vegetable vegetable) {
        try {
            return this.vegetableRepository.save(vegetable);
        } catch (Exception e) {
            throw e;
        }
    }

    public Vegetable update(long id, Vegetable vegetable) {
        return null;
    }

    public void deleteAll() {

    }

    public void deleteById(long id) {

    }
}