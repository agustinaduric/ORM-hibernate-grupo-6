package com.example.hibernate.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;
@Getter
@Setter
@Entity
public class Requisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String descripcion;

    @Override
    public String toString() {
        return "Requisito{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
