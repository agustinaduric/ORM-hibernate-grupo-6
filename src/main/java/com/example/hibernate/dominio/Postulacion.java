package com.example.hibernate.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "Postulacion")
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long postulacion_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publicacion_ID")
    private Publicacion publicacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postulante_id", referencedColumnName = "postulante_id")
    private Postulante postulante;

    public String CV;

    public String reel;

    public LocalDate fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "estado_id")
    private EstadoPostulacion estado;

    private Boolean validaRequisitos;

    @Override
    public String toString() {
        return "Postulacion{" +
                "id=" + postulacion_id +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", postulante=" + (postulante != null ? postulante.getNombre() + " " + postulante.getApellido() : "null") +
                ", publicacion=" + (publicacion != null ? publicacion.getTipoProductoPublicitado() : "null") +
                '}';
    }
}
