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
    private String id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "carrera", nullable = false, length = 50)
    private String carrera;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the carrerra
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrerra to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
