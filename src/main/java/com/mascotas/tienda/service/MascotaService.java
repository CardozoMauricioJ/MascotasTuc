package com.mascotas.tienda.service;

import java.util.List;

import com.mascotas.tienda.entity.Mascota;

public interface MascotaService {

    public List<Mascota> findAll();

    public Mascota findByIdMascota(int idMascota);

    public void save(Mascota mascota);

    public void deleteByIdMascota(int idMascota);

	void update(Mascota mascota);
}
