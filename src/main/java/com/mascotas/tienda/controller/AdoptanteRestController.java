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

import com.mascotas.tienda.entity.Adoptante;
import com.mascotas.tienda.service.AdoptanteService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/tienda") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/tienda/

public class AdoptanteRestController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private AdoptanteService adoptanteService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/tienda/adoptantes*/
    @GetMapping("/adoptantes")
    public List<Adoptante> findAll(){
    	
        //retornará todos los usuarios
        return adoptanteService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/tienda/adoptantes/1*/
    @GetMapping("/adoptantes/{idAdoptante}")
    public Adoptante getAdoptante(@PathVariable int idAdoptante){
    	Adoptante adoptante = adoptanteService.findByIdAdoptante(idAdoptante);

        if(adoptante == null) {
            throw new RuntimeException("Adoptante id_adoptante not found -" + idAdoptante);
        }
        //retornará al usuario con id pasado en la url
        return adoptante;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/tienda/adoptantes/  */
    @PostMapping("/adoptantes")
    public Adoptante addAdoptante(@RequestBody Adoptante adoptante) {
    	adoptante.setIdAdoptante(0);

        //Este metodo guardará al usuario enviado
    	adoptanteService.save(adoptante);

        return adoptante;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/tienda/adoptantes/  */
    @PutMapping("/adoptantes")
    public Adoptante updateAdoptante(@RequestBody Adoptante adoptante) {

    	adoptanteService.update(adoptante);

        //este metodo actualizará al usuario enviado
        return adoptante;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/tienda/adoptantes/1  */
    @DeleteMapping("adoptantes/{idAdoptante}")
    public String deteteAdoptante(@PathVariable int idAdoptante) {

    	Adoptante adoptante = adoptanteService.findByIdAdoptante(idAdoptante);

        if(adoptante == null) {
            throw new RuntimeException("Adoptante idAdoptante not found -" + idAdoptante);
        }

        adoptanteService.deleteByIdAdoptante(idAdoptante);

        //este método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted adoptante idAdoptante - " + idAdoptante;
    }
    
    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/tienda/adopciones*/
    @GetMapping("/adopciones")
    public List<Adoptante> consultarAdopciones(){
        //retornará todos los usuarios
        return adoptanteService.consultarAdopciones();
    }
    
    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + los id de los usuarios
    http://127.0.0.1:8080/tienda/adoptar/1/1*/
    @PostMapping("/adoptar/{idAdoptante}/{idMascota}")
    public Adoptante adoptar(@PathVariable int idAdoptante, @PathVariable int idMascota){
    	Adoptante adoptante = adoptanteService.adoptar(idAdoptante, idMascota);
    	
    	//este método retornará el adoptante con su respectiva mascota 
        return adoptante;
    }

}
