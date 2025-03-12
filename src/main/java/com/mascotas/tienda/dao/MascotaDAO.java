package com.mascotas.tienda.dao;

import java.util.List;

import com.mascotas.tienda.entity.Mascota;


public interface MascotaDAO {

    public List<Mascota> findAll();

    public Mascota findByIdMascota(int idMascota);

    public void save(Mascota mascota);

    public void deleteByIdMascota(int idMascota);

	void update(Mascota mascota);
}
