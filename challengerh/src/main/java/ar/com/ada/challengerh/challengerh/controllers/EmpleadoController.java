package ar.com.ada.challengerh.challengerh.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.challengerh.challengerh.entities.Categoria;
import ar.com.ada.challengerh.challengerh.entities.Empleado;
import ar.com.ada.challengerh.challengerh.excepciones.EmpleadoInfoException;
import ar.com.ada.challengerh.challengerh.models.request.RegistrationRequest;
import ar.com.ada.challengerh.challengerh.models.response.RegistrationResponse;
import ar.com.ada.challengerh.challengerh.services.CategoriaService;
import ar.com.ada.challengerh.challengerh.services.EmpleadoService;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/empleados")

    public List<Empleado> getEmpleados() {

        List<Empleado> es = empleadoService.getEmpleados();

        return es;

    }

    @GetMapping("/empleados/{id}")
    public Empleado getEmpleadoById(@PathVariable int id) {

        Empleado em = empleadoService.buscarPorId(id);

        return em;
    }

    

    @PostMapping("/empleados")
    public RegistrationResponse postRegisterEmpleado(@RequestBody RegistrationRequest req) throws EmpleadoInfoException {
        RegistrationResponse r = new RegistrationResponse();
    

        int empleadoCreadoId = empleadoService.alta(req.nombreEmpleado, req.edad, req.categoriaId, req.sueldo, req.fechaAlta);
        r.isOk = true;
        r.message = "Empleado registrado con éxito";
        r.empleadoId = empleadoCreadoId;

        return r;

    }

    
    /**@GetMapping("/empleados/categorias/{id}")
    public Categoria getPersonaById(@PathVariable int id){


        Categoria c = categoriaService.buscarPorId(id);

        return c;
    }*/

}