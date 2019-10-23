package ar.com.ada.challengerh.challengerh.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.entities.Empleado;
import ar.com.ada.challengerh.challengerh.repo.EmpleadoRepository;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repo;

    @Autowired
    CategoriaService cs;

    public int crearEmpleado(String nombreEmpleado, int edadEmpleado, Integer categoriaId, BigDecimal sueldoEmpleado){
        Empleado e = new Empleado();
        e.setNombreEmpleado(nombreEmpleado);
        e.setEdadEmpleado(edadEmpleado);
        Categoria c = cs.buscarPorId(categoriaId);
        e.setCategoria(c);
        e.setSueldoEmpleado(c.getSueldoBase());
        Date f = new Date();
        e.setFechaAlta(f);
        e.setEstadoEmpleado("Activo");
        repo.save(e);
        return e.getEmpleadoId();
    }

    public List<Empleado> listarEmpleados() { // CON info categoria
        return repo.findAll();

    }

    public Empleado buscarPorId(Integer empleadoId) {

        Optional<Empleado> e = repo.findById(empleadoId);

        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public Empleado updateEmpleado(int empleadoId, String nombreEmpleado, int edadEmpleado, Integer categoriaId) { // excepto sueldo y estado
        Empleado e = this.buscarPorId(empleadoId);
        e.setNombreEmpleado(nombreEmpleado);
        e.setEdadEmpleado(edadEmpleado);
        // e.getCategoria().getEmpleados().remove(e);
        e.setCategoria(cs.buscarPorId(categoriaId));
        // c.getEmpleados().add(e);
        repo.save(e);
        return e;
    }

    public Empleado updateSueldo(int empleadoId, BigDecimal sueldoEmpleado) {
        Empleado e = this.buscarPorId(empleadoId);
        e.setSueldoEmpleado(sueldoEmpleado);
        repo.save(e);
        return e;
    }

    public Empleado bajaEmpleado(int empleadoId) {
        Empleado e = this.buscarPorId(empleadoId);
        e.setEstadoEmpleado("Baja");
        Date f = new Date();
        e.setFechaBaja(f);
        repo.save(e);
        return e;

    }

}