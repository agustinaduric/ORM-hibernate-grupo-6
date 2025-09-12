package com.example.hibernate.dominio;

import javax.persistence.*;

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
    Long numeracion;
}
