package ar.com.ada.challengerh.challengerh.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.entities.Empleado;
import ar.com.ada.challengerh.challengerh.excepciones.CategoriaInfoException;
import ar.com.ada.challengerh.challengerh.repo.CategoriaRepository;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    @Autowired
    EmpleadoService es;

    public int crearCategoria(String nombreCategoria, BigDecimal sueldoBase){
        Categoria c = new Categoria();
        c.setNombreCategoria(nombreCategoria);
        c.setSueldoBase(sueldoBase);
        repo.save(c);

        return c.getCategoriaId();
    }

    public List<Categoria> listarCategorias(){ //SIN empleados????
        return repo.findAll();

    }

    public Categoria buscarPorId(Integer categoriaId) {

        Optional<Categoria> c = repo.findById(categoriaId);

        if (c.isPresent()) {
            return c.get();
        }
        return null;
    }

    public List<Empleado> getEmpleadosCategoriaNombre(String nombreCategoria) throws CategoriaInfoException {
        int id;
        for (Categoria c : repo.findAll()) {
            if (c.nombreCategoria.equals(nombreCategoria)) {
                id = c.getCategoriaId();
                Categoria cat = buscarPorId(id);
                return cat.getEmpleadosPorCategoria();
            }
        }
        throw new CategoriaInfoException("No se encuentra una categoría con ese nombre.");
    }

    public List<Empleado> getEmpleadosCategoriaId(Integer categoriaid) throws CategoriaInfoException {
        for (Categoria c : repo.findAll()) {
            if (c.getCategoriaId() == categoriaid) {
                Categoria cat = buscarPorId(categoriaid);
                return cat.getEmpleadosPorCategoria();
            }
        }
        throw new CategoriaInfoException("No se encuentra una categoría con ese id.");
    }


}
