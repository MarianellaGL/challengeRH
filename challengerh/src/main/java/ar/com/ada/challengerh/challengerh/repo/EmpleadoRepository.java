package ar.com.ada.challengerh.challengerh.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.challengerh.challengerh.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Empleado findByNombreEmpleado(String nombreEmpleado);



}
