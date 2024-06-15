package com.api.turismo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "monumentos_artistas")
public class MonumentoArtista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_monumento", nullable = false)
    private Monumento monumento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    @Column(name = "funcion")
    private String funcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Monumento getMonumento() {
        return monumento;
    }

    public void setMonumento(Monumento monumento) {
        this.monumento = monumento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
}
