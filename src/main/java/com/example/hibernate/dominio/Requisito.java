package com.example.hibernate.dominio;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Requisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String descripcion;

}
