package ar.com.ada.challengerh.challengerh.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.excepciones.CategoriaInfoException;
import ar.com.ada.challengerh.challengerh.models.request.CategoriaRequest;
import ar.com.ada.challengerh.challengerh.models.response.CategoriaResponse;
import ar.com.ada.challengerh.challengerh.repo.CategoriaRepository;
import ar.com.ada.challengerh.challengerh.services.CategoriaService;
import ar.com.ada.challengerh.challengerh.services.EmpleadoService;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    

    @GetMapping ("/categorias")

    public List<Categoria>getCategorias(){

        List<Categoria> lc = categoriaService.getCategorias();

        return lc;



    }




    @PostMapping("/categorias")
    public CategoriaResponse postRegisterCategoria(@RequestBody CategoriaRequest reqcat) throws CategoriaInfoException {
        CategoriaResponse r = new CategoriaResponse();
    

        int categoriaCreadaId = categoriaService.altaCategoria(reqcat.nombreCategoria, reqcat.sueldoBase);
        r.isOk = true;
        r.message = "Categoria generada";
        r.categoriaId = categoriaCreadaId;

        return r;

    }

    


}
