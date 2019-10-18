package ar.com.ada.challengerh.challengerh.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.entities.Empleado;
import ar.com.ada.challengerh.challengerh.excepciones.EmpleadoInfoException;
import ar.com.ada.challengerh.challengerh.repo.EmpleadoRepository;

/**
 * UsuarioService
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repo;

    @Autowired
    CategoriaService cs;

    @PostMapping("/empleados")
    public int alta(String nombreEmpleado, int edad, int categoriaId, BigDecimal sueldo, Date fechaAlta)
            throws EmpleadoInfoException {

        Empleado e = new Empleado();
        e.setNombreEmpleado(nombreEmpleado);
        e.setEdadEmpleado(edad);
        e.setSueldoEmpleado(sueldo);
        e.setFechaAlta(fechaAlta);

        e.getEmpleadoId();

        repo.save(e);

        return e.getEmpleadoId();

    }

    public void save(Empleado e) {
        repo.save(e);
    }

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {

        return repo.findAll();
    }

    @GetMapping("/empleados/{id}")

    public Empleado buscarPorId(int empleadoId) {

        Optional<Empleado> em = repo.findById(empleadoId);

        if (em.isPresent()) {
            return em.get();
        }
        return null;
    }
}
