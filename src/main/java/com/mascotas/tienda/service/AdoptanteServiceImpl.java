package com.mascotas.tienda.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascotas.tienda.dao.AdoptanteDAO;
import com.mascotas.tienda.dao.MascotaDAO;
import com.mascotas.tienda.entity.Adoptante;
import com.mascotas.tienda.entity.Mascota;

@Service
public class AdoptanteServiceImpl implements AdoptanteService {

    @Autowired
    private AdoptanteDAO adoptanteDAO;
    
    @Autowired
    private MascotaDAO mascotaDAO;

    @Override
    public List<Adoptante> findAll() {
        List<Adoptante> listAdoptantes= adoptanteDAO.findAll();
        return listAdoptantes;
        
    }

    @Override
    public Adoptante findByIdAdoptante(int idAdoptante) {
    	Adoptante adoptante = adoptanteDAO.findByIdAdoptante(idAdoptante);
        return adoptante;
        
    }

    @Override
    public void save(Adoptante adoptante) {
    	adoptanteDAO.save(adoptante);

    }
    
    @Override
    public void update(Adoptante adoptante) {
    	Adoptante existente = this.findByIdAdoptante(adoptante.getIdAdoptante());
    	if(existente == null) {
            throw new RuntimeException("No existe adoptante con id: " + adoptante.getIdAdoptante());
        }
    	existente.setNombre(adoptante.getNombre());
    	existente.setDireccion(adoptante.getDireccion());
    	adoptanteDAO.update(existente);

    }

    @Override
    public void deleteByIdAdoptante(int idAdoptante) {
    	adoptanteDAO.deleteByIdAdoptante(idAdoptante);
    	
    }
    
    @Override
    public List<Adoptante> consultarAdopciones() {
        List<Adoptante> listAdoptantes = adoptanteDAO.consultarAdopciones();
        return listAdoptantes;
        
    }
    
    @Override
    public Adoptante adoptar(int idAdoptante, int idMascota) {
    	Mascota mascota = this.mascotaDAO.findByIdMascota(idMascota);
    	Adoptante adoptante = this.findByIdAdoptante(idAdoptante);
    	if(mascota == null) {
            throw new RuntimeException("No existe mascota con id: " + idMascota);
        }
    	if(adoptante == null) {
            throw new RuntimeException("No existe adoptante con id: " + idAdoptante);
        }
    	
    	mascota.setFechaAdopcion(new Date());
    	
    	if (adoptante.getMascotas() != null) {
    		adoptante.getMascotas().add(mascota);
    	} else {
    		adoptante.setMascotas(Arrays.asList(mascota));
    	}
    	adoptanteDAO.update(adoptante);
    	
    	return adoptante;

    }

}
