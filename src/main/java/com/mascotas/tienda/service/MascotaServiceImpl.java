package com.mascotas.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascotas.tienda.dao.MascotaDAO;
import com.mascotas.tienda.entity.Adoptante;
import com.mascotas.tienda.entity.Mascota;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaDAO mascotaDAO;

    @Override
    public List<Mascota> findAll() {
        List<Mascota> listMascotas= mascotaDAO.findAll();
        return listMascotas;
        
    }

    @Override
    public Mascota findByIdMascota(int idMascota) {
    	Mascota mascota = mascotaDAO.findByIdMascota(idMascota);
        return mascota;
        
    }

    @Override
    public void save(Mascota mascota) {
    	mascotaDAO.save(mascota);

    }
    
    @Override
    public void update(Mascota mascota) {
    	Mascota existente = this.findByIdMascota(mascota.getIdMascota());
    	if(existente == null) {
            throw new RuntimeException("No existe mascota con id: " + mascota.getIdMascota());
        }
    	existente.setNombre(mascota.getNombre());
    	existente.setEdad(mascota.getEdad());
    	mascotaDAO.update(existente);

    }

    @Override
    public void deleteByIdMascota(int idMascota) {
    	mascotaDAO.deleteByIdMascota(idMascota);
    	
    }

}