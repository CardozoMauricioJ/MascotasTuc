package com.mascotas.tienda.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private int idMascota;

    @Column(name="nombre")
    private String nombre;

    @Column(name="animal")
    private String animal;
    
    @Column(name="edad")
    private int edad;

    @Column(name="fecha_ingreso")
    private Date fechaIngreso;

    @Column(name="fecha_adopcion")
    private Date fechaAdopcion;
    
    @JsonBackReference 
    @JoinColumn(name = "id_adoptante", nullable = true)
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Adoptante adoptante;

    public Mascota() {}

    public Mascota(int idMascota, String nombre, String animal, int edad, Date fechaIngreso, Date fechaAdopcion, Adoptante adoptante) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.animal = animal;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.fechaAdopcion = fechaAdopcion;
        this.adoptante = adoptante;
    }

    public int getIdMascota() {
        return this.idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnimal() {
        return this.animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public Date getFechaAdopcion() {
        return this.fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }    
    public Adoptante getAdoptante() {
		return adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}

	@Override
    public String toString() {
        return "Mascota [idMascota=" + this.idMascota + ", nombre=" + this.nombre + ", animal=" + this.animal + ", "
        		+ "edad=" + this.edad + ", fechaIngreso=" + this.fechaIngreso + ", fechaAdopcion=" + this.fechaAdopcion + ", "
        				+ "adoptante=" + this.adoptante + "]";
    }

}
    