package com.mascotas.tienda.service;

import java.util.List;

import com.mascotas.tienda.entity.Adoptante;

public interface AdoptanteService {

    public List<Adoptante> findAll();

    public Adoptante findByIdAdoptante(int idAdoptante);

    public void save(Adoptante adoptante);

    public void deleteByIdAdoptante(int idAdoptante);

	void update(Adoptante adoptante);

	List<Adoptante> consultarAdopciones();

	Adoptante adoptar(int idAdoptante, int idMascota);
}
