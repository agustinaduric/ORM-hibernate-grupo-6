package com.example.hibernate;

import com.example.hibernate.dominio.*;
import com.example.hibernate.utils.BDUtils;


import java.time.LocalDate;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

            Publicacion publicacion1 = new Publicacion();

            em.persist(publicacion1);

        //Update
        publicacion1.setUbicacion(new Ubicacion("Estudio 11", "Mitre", "Buenos Aires", "Martinez", 1230));
        publicacion1.setTiempoDisponible(30);
        publicacion1.setTipoProductoPublicitado("Obra de teatro");
        publicacion1.setEdadMinima(18);
        publicacion1.setEdadMaxima(40);
        publicacion1.setFechaPublicacion(LocalDate.now());
        publicacion1.setGeneroPersona(GeneroPersona.MASCULINO);
        publicacion1.setGeneroObra(GeneroObra.DRAMA);
        publicacion1.setRemuneracion(Remuneracion.MENSUAL);

        Requisito req1 = new Requisito();
        req1.setDescripcion("Experiencia previa en teatro");

        Requisito req2 = new Requisito();
        req2.setDescripcion("Disponibilidad horaria por las tardes");

        // Creamos un Set con los requisitos
        List<Requisito> requisitos = new ArrayList<>();
        requisitos.add(req1);
        requisitos.add(req2);

        publicacion1.setRequisitos(requisitos);

        publicacion1.setInformacionExtra("Se requiere disponibilidad para ensayos los fines de semana.");

        Publicacion publicacion2 = new Publicacion();

// Seteamos la ubicación (ManyToOne)
        publicacion2.setUbicacion(new Ubicacion("Teatro Central", "San Martín", "Córdoba", "Centro", 450));

// Otros atributos simples
        publicacion2.setTiempoDisponible(45);
        publicacion2.setTipoProductoPublicitado("Concierto");
        publicacion2.setEdadMinima(16);
        publicacion2.setEdadMaxima(35);
        publicacion2.setFechaPublicacion(LocalDate.of(2025, 10, 15));

// Enums
        publicacion2.setGeneroPersona(GeneroPersona.FEMENINO);
        publicacion2.setGeneroObra(GeneroObra.ACCION);
        publicacion2.setRemuneracion(Remuneracion.SEMANAL);


        List<Requisito> requisitos2 = new ArrayList<>();
        publicacion2.setRequisitos(requisitos2);

        publicacion2.setInformacionExtra("Se requiere buen manejo de instrumentos musicales y puntualidad.");

        em.persist(publicacion2);

        Postulante postulanteA = new Postulante();
        postulanteA.setNombre("Julio");
        postulanteA.setApellido("Bocca");
        em.persist(postulanteA);

        Postulante postulanteB = new Postulante();
        postulanteB.setNombre("Agustina");
        postulanteB.setApellido("Gomez");
        em.persist(postulanteB);

       Postulacion postulacion1 = new Postulacion();
       postulacion1.setFecha(LocalDate.now());
      postulacion1.setEstado(new EstadoPostulacion("Verificada"));
      postulacion1.setPublicacion(publicacion2);
      postulacion1.setValidaRequisitos(true);
      postulacion1.setPostulante(postulanteA);

        Postulacion postulacion2 = new Postulacion();
        postulacion2.setFecha(LocalDate.now());
        postulacion2.setEstado(new EstadoPostulacion("Aprobada"));
        postulacion2.setPublicacion(publicacion2);
        postulacion2.setValidaRequisitos(true);
        postulacion2.setPostulante(postulanteB);

        Postulacion postulacion3 = new Postulacion();
        postulacion3.setFecha(LocalDate.of(2025, 10, 15));
        postulacion3.setEstado(new EstadoPostulacion("Aprobada"));
        postulacion3.setPublicacion(publicacion2);
        postulacion3.setValidaRequisitos(true);
        postulacion3.setPostulante(postulanteB);

      em.persist(postulacion1);
      em.persist(postulacion2);
      em.persist(postulacion3);

        //JPQL Query
        List<Postulacion> postulaciones = em
                // equivalente a: select * from persona where persona.nombre = 'Julian'
                .createQuery("select p from Postulacion p where p.fecha <> :fecha", Postulacion.class) //ojo, query no tipada
                .setParameter("fecha", LocalDate.of(2025, 10, 15))
                .getResultList();

        System.out.println(postulaciones);
        System.out.println(publicacion1);
        System.out.println(publicacion2);

        //Delete
        for (Postulacion post : postulaciones) {
            em.remove(post);
        }

        BDUtils.commit(em);
    }

}
