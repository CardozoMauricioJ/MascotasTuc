package com.mascotas.tienda.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="adoptante")
public class Adoptante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_adoptante")
    private int idAdoptante;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private long dni;

    @Column(name="telefono")
    private long telefono;
    
    @Column(name="direccion")
    private String direccion;
    
	@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adoptante")
    private List<Mascota> mascotas;
    
    public Adoptante() {}

    public Adoptante(int idAdoptante, String nombre, String apellido, int dni, int telefono, String direccion, List<Mascota> mascotas) {
        this.idAdoptante = idAdoptante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mascotas = mascotas;
    }

    public int getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(int idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
    public String toString() {
        return "Adoptante [idAdoptante=" + this.idAdoptante + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", dni=" + this.dni
                + ", telefono=" + this.telefono + ", direccion=" + this.direccion + " mascotas=" + this.mascotas + "]";
    }


}
