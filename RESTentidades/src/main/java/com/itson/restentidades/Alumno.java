/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.restentidades;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author yohan
 */
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;  // Cambiado de String a Long

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "carrera", nullable = false, length = 50)
    private String carrera;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String carrera) {  // Cambiado de String a Long
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
