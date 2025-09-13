package com.example.hibernate.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_ID")
    private Long ubicacionId;

    String nombre;
    String calle;
    String provincia;
    String localidad;
    Integer numeracion;

    public Ubicacion(String nombre, String calle, String provincia, String localidad, Integer numeracion) {
        this.nombre = nombre;
        this.calle = calle;
        this.provincia = provincia;
        this.localidad = localidad;
        this.numeracion = numeracion;
    }
    public Ubicacion(){

    }
    @Override
    public String toString() {
        return calle + " " + numeracion + ", " + localidad + " (" + provincia + ")";
    }
}
