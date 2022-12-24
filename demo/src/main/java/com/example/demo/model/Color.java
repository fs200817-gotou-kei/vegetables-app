package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "COLOR")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME_JA")
    private String nameJa;

    @Column(name = "NAME_EN")
    private String nameEn;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    // orphanRemovalをtrueにすることでおそらくColorが削除されたときそれを設定しているvegetableも削除するということ
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Vegetable> vegetableList;
}
