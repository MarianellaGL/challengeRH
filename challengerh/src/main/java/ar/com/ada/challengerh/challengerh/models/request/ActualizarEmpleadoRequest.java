package ar.com.ada.challengerh.challengerh.models.request;

import java.math.BigDecimal;
import java.util.Date;

public class ActualizarEmpleadoRequest {

    public String nombreEmpleado;
    public int edadEmpleado;
    public BigDecimal sueldoEmpleado;
    public Integer categoriaId;
    public Integer empleadoId;
    public Date fechaAlta;
    public Date fechaBaja;
}