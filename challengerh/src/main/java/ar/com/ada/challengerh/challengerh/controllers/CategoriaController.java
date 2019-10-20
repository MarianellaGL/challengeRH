package ar.com.ada.challengerh.challengerh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.models.request.CategoriaRequest;
import ar.com.ada.challengerh.challengerh.models.response.CategoriaResponse;
import ar.com.ada.challengerh.challengerh.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService cs;

    @PostMapping("/categorias")
    public CategoriaResponse altaCategoria(@RequestBody CategoriaRequest req) {
        CategoriaResponse r = new CategoriaResponse();

        int categoriaCreadaId = cs.crearCategoria(req.nombreCategoria, req.sueldoBase);

        r.isOk = true;
        r.message = "Categoría " + req.nombreCategoria + " creada con éxito.";
        r.categoriaId = categoriaCreadaId;
        return r;

    }

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
        List<Categoria> lc = cs.listarCategorias();

        return lc;
    }

}
