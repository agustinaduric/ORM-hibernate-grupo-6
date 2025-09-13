package com.example.hibernate.dominio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "postulante")
public class Postulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postulante_id;

    private String nombre;

    private String apellido;

    @OneToMany(mappedBy = "postulante")
    private List<Postulacion> postulaciones;

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
