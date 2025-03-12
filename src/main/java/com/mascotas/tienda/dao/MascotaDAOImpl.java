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
public class MascotaDAOImpl implements MascotaDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Mascota> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Mascota> theQuery = currentSession.createQuery("from Mascota", Mascota.class);
        List<Mascota> mascotas = theQuery.getResultList();

        return mascotas;

    }

    @Override
    public Mascota findByIdMascota(int idMascota) {
        Session currentSession = entityManager.unwrap(Session.class);
        Mascota mascota = currentSession.get(Mascota.class, idMascota);

        return mascota;
    }

    @Override
    public void save(Mascota mascota) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        currentSession.saveOrUpdate(mascota);

    }
    
    @Override
    public void update(Mascota mascota) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        Transaction tx = currentSession.beginTransaction();
        currentSession.update(mascota);
        tx.commit();
        currentSession.close();
        
    }

    @Override
    public void deleteByIdMascota(int idMascota) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("delete from Mascota where id_mascota=:idMascota");
        
        Transaction tx = currentSession.beginTransaction();
        theQuery.setParameter("idMascota", idMascota);
        theQuery.executeUpdate();
        tx.commit();
        currentSession.close();

    }

}