package ar.com.ada.challengerh.challengerh.entities;

import java.math.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    private String nombre;
    private BigDecimal sueldoBase;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Empleado> empleados = new ArrayList<Empleado>();

    @OneToOne(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Empleado empleado;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldo) {
        this.sueldoBase = sueldo;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }


    public List<Categoria> getCategoriasTodas(List<Categoria> nombreCategorias) {
        return nombreCategorias;
    }

    public int getCategoriaId() {

        return categoriaId;
    }

    public void setCategoriaId() {
        this.categoriaId = 0;
    }

    public Categoria(String nombre, BigDecimal sueldoBase, Integer categoriaId) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.categoriaId = categoriaId;

    }

    public Categoria(Empleado em) {

        this.setEmpleado(em);
        em.setCategoria(this);

    }

	public Categoria() {
	}

	void setEmpleado(Empleado empleado) {
       this.empleado=empleado;
    }

    public void getCategoria(int empleadoId) {
	}


}