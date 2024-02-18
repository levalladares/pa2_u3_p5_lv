package com.uce.edu.demo.funcional;

public class MetodosReferenciados {
	
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "12345";
		cedula = cedula + "provincia"+"referenciado";
		return cedula;
	}

	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("se procesao la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Luis".contains(cadena);
	}
	
	public boolean procesar(Integer numero) {
		return 8 == numero;
	}
	
	public Ciudadano cambiar(Empleado empleado) {
		Ciudadano ciu = new Ciudadano();
		String nombre = empleado.getNombreCompleto().split(" ")[0];
		String apellido = empleado.getNombreCompleto().split(" ")[1];
		ciu.setNombre(nombre);
		ciu.setApellido(apellido);
		ciu.setProvincia("chimborazo");
		return ciu;
	}
	
	public Empleado procesar (Empleado emp) {
		emp.setNombreCompleto(emp.getNombreCompleto()+ " "+emp.getPais());
		emp.setPais(emp.getPais()+" de nacimiento");
		return emp;
	}
	
}
