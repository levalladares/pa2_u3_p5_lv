package com.uce.edu.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula= "12345";
		cedula = cedula +"provincia";
		return cedula;
	}

	
}
