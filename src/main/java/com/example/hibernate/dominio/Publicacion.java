package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long publicacion_id;

    public String tipoProductoPublicitado;

    public LocalDate fechaPublicacion;

    public Integer tiempoDisponible;

    @Enumerated(EnumType.STRING)
    public GeneroPersona generoPersona;

    @Enumerated(EnumType.STRING)
    public GeneroObra generoObra;

    public Integer edadMinima;

    public Integer edadMaxima;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

    @Enumerated(EnumType.STRING)
    public Remuneracion remuneracion;

    public String informacionExtra;

    @ManyToMany
    @JoinTable(name = "RequisitoXPublicacion",
            joinColumns = @JoinColumn(name = "Publicacion_ID"),
            inverseJoinColumns = @JoinColumn(name = "requisito_ID")
    )
    private List<Requisito> requisitos;

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
