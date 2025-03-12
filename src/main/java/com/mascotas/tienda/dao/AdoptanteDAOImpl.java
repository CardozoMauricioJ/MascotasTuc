package com.mascotas.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mascotas.tienda.entity.Adoptante;
import com.mascotas.tienda.entity.Mascota;

@Repository
public class AdoptanteDAOImpl implements AdoptanteDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Adoptante> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Adoptante> theQuery = currentSession.createQuery("from Adoptante", Adoptante.class);

        List<Adoptante> adoptantes = theQuery.getResultList();

        return adoptantes;

    }

    @Override
    public Adoptante findByIdAdoptante(int idAdoptante) {
        Session currentSession = entityManager.unwrap(Session.class);

        Adoptante adoptante = currentSession.get(Adoptante.class, idAdoptante);

        return adoptante;
        
    }

    @Override
    public void save(Adoptante adoptante) {
        Session currentSession = entityManager.unwrap(Session.class);

        if (adoptante.getMascotas() != null) adoptante.getMascotas().forEach((mascota) -> mascota.setAdoptante(adoptante));
        
        currentSession.saveOrUpdate(adoptante);  

    }
    
    @Override
    public void update(Adoptante adoptante) {
        Session currentSession = entityManager.unwrap(Session.class);

        if (adoptante.getMascotas() != null) adoptante.getMascotas().forEach((mascota) -> mascota.setAdoptante(adoptante));
        
        Transaction tx = currentSession.beginTransaction();
        currentSession.update(adoptante);
        tx.commit();
        currentSession.close();       

    }

    @Override
    public void deleteByIdAdoptante(int idAdoptante) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Adoptante> theQuery = currentSession.createQuery("delete from Adoptante where id_adoptante=:idAdoptante");

        theQuery.setParameter("idAdoptante", idAdoptante);
        theQuery.executeUpdate();

    }
    
    @Override
    public List<Adoptante> consultarAdopciones() {
        Session currentSession = entityManager.unwrap(Session.class);

        List<Adoptante> adoptantes = currentSession.createQuery("select ad from Adoptante ad " +
        		 "where ad.mascotas IS NOT EMPTY", Adoptante.class )
        		.list();

        return adoptantes;
        
    }

}