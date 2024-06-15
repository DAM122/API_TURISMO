package com.api.turismo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_monumento", nullable = false)
    private Monumento monumento;
    @Column(name = "mensaje", nullable = false)
    private String mensaje;
    @Column(name = "puntuacion", nullable = false)
    private Double puntuacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Monumento getMonumento() {
        return monumento;
    }

    public void setMonumento(Monumento monumento) {
        this.monumento = monumento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
