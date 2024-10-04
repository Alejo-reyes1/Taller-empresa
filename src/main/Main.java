package main;

import javax.swing.JOptionPane;

import clases.Empleado;
import clases.Empresa;

public class Main {
	public static Empresa empresa= new Empresa("Empresa");

	public static void main(String[] args) {
		int opcionMenu;
		String menu="1.Agregar empleado\n"+
		"2.Eliminar empleado\n"+
		"3.Actualizar empelado\n"+
		"4.Listar empleados\n"+
		"5.Promedio de los salario de la empresa\n"+
		"6.Nomina total de la empresa\n"+
		"7.Empleado con mejor sueldo\n"+
		"8.Empleado con mas comisiones\n"+
		"9.Empleados con un salario dentro de un rango\n"+
		"10.Salir";
		
		do {
			opcionMenu=Integer.parseInt(JOptionPane.showInputDialog(menu));
			menuSelecionado(opcionMenu);
		}while(opcionMenu<10);		
	}
	private static void menuSelecionado(int opcionMenu) {
		switch(opcionMenu) {
		case 1:
			agregarEmpleado();
			break;
		case 2:
			eliminarEmpleado();
			break;
		case 3:
			actualizarEmpleado();
			break;
		case 4:
			listarEmpleados();
			break;
		case 5:
			promedioSalarios();
			break;
		case 6:
			nominaTotal();
			break;
		case 7:
			mejorSueldo();
			break;
		case 8:
			mejorComisiones();
			break;
		case 9:
			salarioEnRango();
			break;
		}
	}
	private static void agregarEmpleado() {
		String nombre=JOptionPane.showInputDialog("Agrege el nombre del empleado");
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
		double salario=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado"));
		double comisiones=Double.parseDouble(JOptionPane.showInputDialog("Ingrese las comisiones del empleado"));
		Empleado e=new Empleado(nombre,edad,salario,comisiones);
		boolean agregado=empresa.agregarEmpleado(e);
		if(agregado) {
			JOptionPane.showMessageDialog(null, "El empleado fue agregado exitosamente");
		}else {
			JOptionPane.showMessageDialog(null, "El empleado ya existe");
		}		
	}
	private static void eliminarEmpleado() {
		String nombre=JOptionPane.showInputDialog("Ingrese el nombre del empleado que desea eliminar");
		boolean estado=empresa.eliminarEmpleado(nombre);
		if(estado) {
			JOptionPane.showMessageDialog(null, "El empleado fue eliminado");
		}else {
			JOptionPane.showMessageDialog(null, "El usuario no existia");
		}
	}
	private static void actualizarEmpleado() {
		String nombreEmpleado=JOptionPane.showInputDialog("Ingrese el nombre del empleado que desea actualizar");
		Empleado e=empresa.buscarEmpleado(nombreEmpleado);
		if(e!=null) {
			String nombre=JOptionPane.showInputDialog("Agrege el nombre del empleado");
			int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
			double salario=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado"));
			double comisiones=Double.parseDouble(JOptionPane.showInputDialog("Ingrese las comisiones del empleado"));
			empresa.actulizarContacto(e, nombre, edad, salario, comisiones);
			JOptionPane.showMessageDialog(null, "El empleado fue actualizado");
		}
	}
	private static void listarEmpleados() {
		System.out.println("Los empleados de la empresa son:");
		empresa.listarEmpleados();
	}
	private static void promedioSalarios() {
		double promedioSalarios=empresa.promedioSalario();
		System.out.println(promedioSalarios);
	}
	private static void nominaTotal() {
		double nominaEmpresa=empresa.nominaTotal();
		System.out.println("La nomina que debe la empresa pagar en salarios es de: "+nominaEmpresa);
	}
	private static void mejorSueldo() {
		String mejorSueldoEmpleado=empresa.mejorSueldo();
		System.out.println(mejorSueldoEmpleado);
	}
	private static void mejorComisiones() {
		String empleadoMejorComision=empresa.mejorComision();
		System.out.println(empleadoMejorComision);
	}
	private static void salarioEnRango() {
		double salarioMin=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario minimo dentro del rango"));
		double salarioMax=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario maximo dentro del rango"));
		String listaSalarioEnRango=empresa.listarEmpleadosPorRango(salarioMin, salarioMax);
		System.out.println("La lista de los empleados en rango es la siguiente:\n"+listaSalarioEnRango);
	}
}
