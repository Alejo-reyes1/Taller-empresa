package clases;

import java.util.ArrayList;

public class Proyectos {
	private String nombre;
	private Empleado responsable;
	private int duracionMeses;
	private double costo;
	private ArrayList<Empleado>empleados;
	
	public Proyectos(String nombre,int duracionMeses, double costo) {
		this.nombre = nombre;
		this.duracionMeses = duracionMeses;
		this.costo = costo;
		this.empleados=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void agregarEmpleado(Empleado e) {
		this.empleados.add(e);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	//metodos pedidos
	
	@Override
	public String toString() {
		return "Proyectos [empleados=" + empleados + "]";
	}

	public void asignarEmpleado(Empleado responsable) {
		this.responsable = responsable;
	}

	public int informarDuracion() {
		return duracionMeses;
	}

	

}
