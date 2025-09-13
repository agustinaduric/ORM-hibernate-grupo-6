package com.example.hibernate.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

    @Enumerated(EnumType.STRING)
    public Remuneracion remuneracion;

    public String informacionExtra;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "RequisitoXPublicacion",
            joinColumns = @JoinColumn(name = "Publicacion_ID"),
            inverseJoinColumns = @JoinColumn(name = "requisito_ID")
    )
    private List<Requisito> requisitos;

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + publicacion_id +
                ", tipoProducto='" + tipoProductoPublicitado + '\'' +
                ", ubicacion=" + ubicacion +
                ", edadMin=" + edadMinima +
                ", edadMax=" + edadMaxima +
                ", generoPersona=" + generoPersona +
                ", generoObra=" + generoObra +
                ", remuneracion=" + remuneracion +
                ", requisitos=" + requisitos +
                '}';
    }
}
