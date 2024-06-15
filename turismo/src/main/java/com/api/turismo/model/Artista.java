    package com.api.turismo.model;

    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.time.LocalDate;

    @Entity
    @Table(name = "artistas")
    public class Artista implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "nombre", nullable = false)
        private String nombre;
        @Column(name = "apellido1", nullable = false)
        private String apellido1;
        @Column(name = "apellido2", nullable = false)
        private String apellido2;
        @Column(name = "profesion", nullable = false)
        private String profesion;
        @Column(name = "fecha_nacimiento")
        private LocalDate fechaNacimiento;
        @Column(name = "fecha_muerte")
        private LocalDate fechaMuerte;
        @Column(name = "procedencia")
        private String procedencia;
        @Column(name = "pais_origen")
        private String paisOrigen;
        @Column(name = "historia")
        private String historia;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido1() {
            return apellido1;
        }

        public void setApellido1(String apellido1) {
            this.apellido1 = apellido1;
        }

        public String getApellido2() {
            return apellido2;
        }

        public void setApellido2(String apellido2) {
            this.apellido2 = apellido2;
        }

        public String getProfesion() {
            return profesion;
        }

        public void setProfesion(String profesion) {
            this.profesion = profesion;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public LocalDate getFechaMuerte() {
            return fechaMuerte;
        }

        public void setFechaMuerte(LocalDate fechaMuerte) {
            this.fechaMuerte = fechaMuerte;
        }

        public String getProcedencia() {
            return procedencia;
        }

        public void setProcedencia(String procedencia) {
            this.procedencia = procedencia;
        }

        public String getPaisOrigen() {
            return paisOrigen;
        }

        public void setPaisOrigen(String paisOrigen) {
            this.paisOrigen = paisOrigen;
        }

        public String getHistoria() {
            return historia;
        }

        public void setHistoria(String historia) {
            this.historia = historia;
        }
    }

