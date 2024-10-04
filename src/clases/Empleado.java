package clases;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private int edad;
	private double salario;
	private double comsiones;
	private LocalDate fechaIngreso;
	
	public Empleado(String nombre, int edad, double salario, double comsiones) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		this.comsiones = comsiones;
		this.fechaIngreso=LocalDate.now();
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getComsiones() {
		return comsiones;
	}
	
	public void setComsiones(double comsiones) {
		this.comsiones = comsiones;
	}
	public double salarioTotal() {
		double salarioTotal=this.salario+this.comsiones;
		LocalDate ahora=LocalDate.now();
		LocalDate tiempoEmpresa=this.fechaIngreso;
		for(int x=0;x<ahora.getYear()-tiempoEmpresa.getYear();x++) {
			salarioTotal+=50000;
		}
		return salarioTotal;
	}
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", comsiones=" + comsiones
				+ "]";
	}
	
}
