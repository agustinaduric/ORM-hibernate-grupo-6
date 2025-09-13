package com.example.hibernate.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
@Getter
@Setter
@Entity
public class EstadoPostulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    public EstadoPostulacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoPostulacion() {
    }
    @Override
    public String toString() {
        return "id: " + id + "descripcion: " + descripcion;
    }
}
