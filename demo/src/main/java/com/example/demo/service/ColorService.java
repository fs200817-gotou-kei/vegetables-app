package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Color;
import com.example.demo.repository.ColorRepository;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public Optional<Color> getById(long id) {
        try {
            return this.colorRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Color create(Color color) {
        try {
            LocalDateTime now = LocalDateTime.now();
            color.setCreatedAt(now);
            color.setUpdatedAt(now);
            return this.colorRepository.save(color);
        } catch (Exception e) {
            throw e;
        }
    }
}
