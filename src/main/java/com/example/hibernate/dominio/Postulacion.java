package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long postulacion_id;

    @ManyToOne
    @JoinColumn(name = "publicacion_ID")
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "postulante_id")
    private Postulante postulante;

    public String CV;

    public String reel;

    public LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPostulacion estado;

    private Boolean validaRequisitos;

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public EstadoPostulacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPostulacion estado) {
        this.estado = estado;
    }
}
