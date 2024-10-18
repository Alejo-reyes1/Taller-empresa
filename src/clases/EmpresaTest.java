package clases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EmpresaTest {
	@Test
	public void eliminarEmpleado() {
		Empresa e=new Empresa("empresa");
		Empleado e1=new Empleado("alejo",17,10000,10000);
		e.agregarEmpleado(e1);
		int tamañoLista=e.getEmpleados().size();
		e.eliminarEmpleado("alejo");
		assertEquals(tamañoLista-1,e.getEmpleados().size());	
	}
	@Test
	public void agregarEmpleado() {
		Empresa e=new Empresa("empresa");
		Empleado e1=new Empleado("alejo",17,10000,10000);
		e.agregarEmpleado(e1);
		ArrayList<Empleado> tamañoLista=e.getEmpleados();
		Empleado empleadoAgregado=tamañoLista.get(tamañoLista.size()-1);
		String nombreEmpleado=empleadoAgregado.getNombre();
		assertEquals(e1.getNombre(),nombreEmpleado);
	}	
	@Test
	public void comprobarPromedioSalario() {
		Empresa empresa=new Empresa("empresa");
		Empleado e1=new Empleado("alejo",17,10000,10000);
		Empleado e2=new Empleado("pedro",24,300,450000);
		empresa.agregarEmpleado(e1);
		empresa.agregarEmpleado(e2);
		double promedioSalario=(e1.salarioTotal()+e2.salarioTotal())/empresa.getEmpleados().size();
		assertEquals(promedioSalario,empresa.promedioSalario());
	}
	@Test
	public void comprobarProyectoMasLargo() {
		Empresa empresa=new Empresa("empresa");
		Proyectos p1=new Proyectos("proyecto1",5,3000.0);
		Proyectos p2=new Proyectos("proyecto2",20,3000.0);
		empresa.agregarProyecto(p1);
		empresa.agregarProyecto(p2);
		Proyectos proyectosMasLargo=empresa.proyectoMasLargo();
		assertEquals(p2,proyectosMasLargo);	
	}

}
