package ar.com.ada.challengerh.challengerh.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empleadoId;
     @Column(name = "nombre_empleado")
	public String nombreEmpleado;
     @Column(name = "edad_empleado")
    private int edadEmpleado;
    @Column(name = "estado_empleado")
    private String estadoEmpleado;
     @Column(name = "fecha_alta")
    private Date fechaAlta;
     @Column(name = "fecha_baja")
    private Date fechaBaja;
     @Column(name = "sueldo_empleado")
    private BigDecimal sueldoEmpleado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    Categoria categoria;

    public Empleado(int empleadoId, String nombreEmpleado, int edadEmpleado, Categoria categoria, String estadoEmpleado,
            Date fechaAlta, Date fechaBaja) {
        this.empleadoId = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.edadEmpleado = edadEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(int edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public BigDecimal getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(BigDecimal sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    @JsonIgnore

    public Categoria getCategoria() {
        return categoria;
    }
    @JsonIgnore
    public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    public Empleado() {
    }
}