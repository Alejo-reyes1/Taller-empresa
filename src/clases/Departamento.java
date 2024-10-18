package clases;

import java.util.ArrayList;

public class Departamento {
	private String nombre;
	private ArrayList<Empleado>empleados;
	
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.empleados= new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void agregarEmpleado(Empleado e){
		this.empleados.add(e);
	}
	public double calcularGastosSalarial() {
		double gastosDepartamento=0;
		for(Empleado e:this.empleados) {
			gastosDepartamento+=e.salarioTotal();
		}
		return gastosDepartamento;	
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", empleados=" + empleados + "]";
	}
	
}
