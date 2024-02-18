package com.uce.edu.demo.funcional;

import java.math.BigDecimal;

public class Empleado {
	private String nombreCompleto;
	private String pais;
	
	//set y get
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	@Override
	public String toString() {
		return "Empleado [nombreCompleto=" + nombreCompleto + ", pais=" + pais + "]";
	} 
	
	
	
}
