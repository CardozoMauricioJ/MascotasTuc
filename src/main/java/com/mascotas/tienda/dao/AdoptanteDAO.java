package com.mascotas.tienda.dao;

import java.util.List;

import com.mascotas.tienda.entity.Adoptante;
import com.mascotas.tienda.entity.Mascota;


public interface AdoptanteDAO {

    public List<Adoptante> findAll();

    public Adoptante findByIdAdoptante(int idAdoptante);

    public void save(Adoptante adoptante);

    public void deleteByIdAdoptante(int idAdoptante);

	void update(Adoptante adoptante);

	List<Adoptante> consultarAdopciones();
}