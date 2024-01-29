package com.uce.edu.demo.hotel.repository;

import com.uce.edu.demo.hotel.repository.modelo.Habitacion;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;

public interface IHabitacionRepository {
	
	public Habitacion seleccionar (Integer id);
	public void insertar (Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
	public void eliminar(Integer id);
	
	public Hotel seleccionarPClase(String clase);
	
	public Habitacion seleccionarPorNumero(String numero);
	

}
