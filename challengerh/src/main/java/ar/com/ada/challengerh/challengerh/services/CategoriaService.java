package ar.com.ada.challengerh.challengerh.services;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.excepciones.CategoriaInfoException;
import ar.com.ada.challengerh.challengerh.repo.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;
    @Autowired
    EmpleadoService es;

    public void save(Categoria c) {

        repo.save(c);
    }

    public List<Categoria> getCategorias() {

        return repo.findAll();
    }

    @GetMapping("/categorias")
    public Categoria buscarPorId(int categoriaId) {

        Optional<Categoria> c = repo.findById(categoriaId);

        if (c.isPresent()) {
            return c.get();
        }
        return null;
    }

    @PostMapping("/categorias")
    public int altaCategoria(String nombreCategoria, BigDecimal sueldoBase) throws CategoriaInfoException {

        Categoria c = new Categoria();
        c.setNombre(nombreCategoria);
        c.setSueldoBase(sueldoBase);

        c.setCategoriaId();

        return c.getCategoriaId();

    }

}
