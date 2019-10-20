package ar.com.ada.challengerh.challengerh.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.entities.Empleado;
import ar.com.ada.challengerh.challengerh.models.request.ActualizarEmpleadoRequest;
import ar.com.ada.challengerh.challengerh.models.request.ActualizarSueldoRequest;
import ar.com.ada.challengerh.challengerh.models.request.RegistrationRequest;
import ar.com.ada.challengerh.challengerh.models.response.ActualizarEmpleadoResponse;
import ar.com.ada.challengerh.challengerh.models.response.RegistrationResponse;
import ar.com.ada.challengerh.challengerh.services.CategoriaService;
import ar.com.ada.challengerh.challengerh.services.EmpleadoService;

/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService es;

    @Autowired
    CategoriaService cs;

    @PostMapping("/empleados")
    public RegistrationResponse altaEmpleado(@RequestBody RegistrationRequest req){
        RegistrationResponse r = new RegistrationResponse();

        int empleadoCreadoId = es.crearEmpleado(req.nombreEmpleado, req.edadEmpleado, req.categoriaId, req.sueldo);

        r.isOk = true;
        r.message = "Empleado " + req.nombreEmpleado + " creado con éxito.";
        r.empleadoId = empleadoCreadoId;
        return r;
        
    }

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados()
    {
        List<Empleado> le = es.listarEmpleados();
        
        return le;
    }

    @GetMapping("/empleados/{id}")
    public Empleado getEmpleado(@PathVariable int empleadoId){

        Empleado e = es.buscarPorId(empleadoId);
        return e;
    }

    @GetMapping("/empleados/categorias/{categoriaId}")
    public List<Empleado> getEmpleadosCategoria(@PathVariable int categoriaId){
        Categoria c = cs.buscarPorId(categoriaId);
        List<Empleado> le = c.getEmpleadosPorCategoria();
        return le;
    }

    @PutMapping("/empleados/{id}") //crear responses y requests específicos
    public ActualizarEmpleadoResponse updateEmpleado(@PathVariable int id, @RequestBody ActualizarEmpleadoRequest req){
        ActualizarEmpleadoResponse r = new ActualizarEmpleadoResponse();

        Empleado e = es.updateEmpleado(id, req.nombreEmpleado, req.edadEmpleado, req.categoriaId);

        r.isOk = true;
        r.message = "Empleado " + req.nombreEmpleado + " actualizado con éxito.";
        r.empleadoid = e.getEmpleadoId();
        return r;
    }

    @PutMapping("/empleados/{id}/sueldos")
    public ActualizarEmpleadoResponse updateSueldo(@PathVariable int empleadoId, @RequestBody ActualizarSueldoRequest req){
        ActualizarEmpleadoResponse r = new ActualizarEmpleadoResponse();

        Empleado e = es.updateSueldo(empleadoId, req.sueldoEmpleado);

        r.isOk = true;
        r.message = "Empleado " + e.nombreEmpleado + " actualizado con éxito.";
        r.empleadoid = e.getEmpleadoId();
        return r;
    }

    @DeleteMapping("/empleados/{id}")
    public ActualizarEmpleadoResponse bajaEmpleado(@PathVariable int empleadoId){
        ActualizarEmpleadoResponse r = new ActualizarEmpleadoResponse();

        Empleado e = es.bajaEmpleado(empleadoId);

        r.isOk = true;
        r.message = "Estado de empleado " + e.nombreEmpleado + " modificado con éxito.";
        r.empleadoid = e.getEmpleadoId();
        return r;
    }
}