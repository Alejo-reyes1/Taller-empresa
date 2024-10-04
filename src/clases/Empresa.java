package clases;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado>empleados;

	public Empresa(String nombre) {
		this.nombre=nombre;
		this.empleados=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean agregarEmpleado(Empleado e) {
		boolean existe=empleadoExiste(e);
		if(!existe) {
			this.empleados.add(e);	
			return true;
		}
		return false;
	}
	private boolean empleadoExiste(Empleado empleado) {
		for(Empleado e:this.empleados) {
			String nombre=empleado.getNombre();
			if(e.getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}
	public Empleado buscarEmpleado(String nombre) {
		for(Empleado e:this.empleados) {
			if(e.getNombre().equalsIgnoreCase(nombre)) {
				return e;
			}
		}
		return null;
	}
	public boolean eliminarEmpleado(String nombre) {
		Empleado e=buscarEmpleado(nombre);
		if(e==null) {
			return false;
		}else {
			empleados.remove(e);
			return true;
		}
		
	}
	public void actulizarContacto(Empleado e,String nombre,int edad, double salario, double comisiones) {
		e.setNombre(nombre);
		e.setEdad(edad);
		e.setSalario(salario);
		e.setComsiones(comisiones);
	}
	public void listarEmpleados() {
		for(Empleado e: this.empleados) {
			System.out.println(e.toString());
		}
	}
	public double promedioSalario() {
		double totalSalario=0;
		for(Empleado e:this.empleados) {
			totalSalario+=e.salarioTotal();
		}
		double promedioTotal=totalSalario/this.empleados.size();
		return promedioTotal;
	}
	public double nominaTotal() {
		double nominaTotal=0;
		for(Empleado e: this.empleados) {
			nominaTotal+=e.salarioTotal();
		}
		return nominaTotal;
	}
	public String mejorSueldo() {
		Empleado empleadoMejorSueldo=null;
		for(Empleado e:this.empleados) {
			if(empleadoMejorSueldo.salarioTotal()<e.salarioTotal()) {
				empleadoMejorSueldo=e;
			}
		}
		String sueldoEmpleado="El empleado con mejor sueldo es: "+ empleadoMejorSueldo.toString();
		return sueldoEmpleado;
	}
	public String mejorComision() {
		Empleado empleadoMejorComision=null;
		for(Empleado e:this.empleados) {
			if(empleadoMejorComision.getComsiones()<e.getComsiones()) {
				empleadoMejorComision=e;
			}
		}
		String comisionEmpleado="El empleado con mejor comision es: "+empleadoMejorComision.toString();
		return comisionEmpleado;
	}
	public String listarEmpleadosPorRango(double salarioMin, double salarioMax) {
		String listaEmpleadosEnRango="";
		for(Empleado e:this.empleados) {
			double salarioEmpleado=e.salarioTotal();
			if(salarioEmpleado>=salarioMin||salarioEmpleado<=salarioMax) {
				listaEmpleadosEnRango+=e.toString()+"\n";				
			}
		}
		return listaEmpleadosEnRango;
	}
	public double incrementarSalario(String nombre, int incremento) {
		double salarioIncremento=0;
		Empleado e=buscarEmpleado(nombre);
		double salarioOriginal=e.salarioTotal();
		salarioIncremento = salarioOriginal + salarioOriginal * (incremento / 100);
		e.setSalario(salarioOriginal);
		return salarioIncremento;
	}
}
