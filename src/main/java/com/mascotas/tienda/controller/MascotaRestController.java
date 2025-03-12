package com.mascotas.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mascotas.tienda.entity.Mascota;
import com.mascotas.tienda.service.MascotaService;

//Indicamos que es un controlador rest
@RestController
@RequestMapping("/tienda") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/tienda/

public class MascotaRestController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private MascotaService mascotaService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/tienda/mascotas*/
    @GetMapping("/mascotas")
    public List<Mascota> findAll(){
        //retornará todos los usuarios
        return mascotaService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/tienda/mascotas/1*/
    @GetMapping("/mascotas/{idMascota}")
    public Mascota getMascota(@PathVariable int idMascota){
    	Mascota mascota = mascotaService.findByIdMascota(idMascota);

        if(mascota == null) {
            throw new RuntimeException("Mascota id_mascota not found -" + idMascota);
        }
        
        //retornará al usuario con id pasado en la url
        return mascota;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/tienda/mascotas/*/
    @PostMapping("/mascotas")
    public Mascota addMascota(@RequestBody Mascota mascota) {
    	mascota.setIdMascota(0);

        //Este metodo guardará al usuario enviado
    	mascotaService.save(mascota);

        return mascota;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/tienda/mascotas/*/
    @PutMapping("/mascotas")
    public Mascota updateMascota(@RequestBody Mascota mascota) {

    	mascotaService.update(mascota);

        //este metodo actualizará al usuario enviado
        return mascota;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/tienda/mascotas/1*/
    @DeleteMapping("mascotas/{idMascota}")
    public String deteteMascota(@PathVariable int idMascota) {

    	Mascota mascota = mascotaService.findByIdMascota(idMascota);

        if(mascota == null) {
            throw new RuntimeException("Mascota id_mascota not found -" + idMascota);
        }

        mascotaService.deleteByIdMascota(idMascota);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id_mascota - " + idMascota;
    }
   
}
