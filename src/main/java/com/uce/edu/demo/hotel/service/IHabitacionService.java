package com.uce.edu.demo.hotel.service;

import com.uce.edu.demo.hotel.repository.modelo.Habitacion;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;

public interface IHabitacionService {
	
	public Habitacion buscar (Integer id);
	public void guardar (Habitacion habitacion);
	public void actualizar(Habitacion habitacion);
	public void eliminar(Integer id);
	public Hotel buscarPClase(String clase);
	
	public Habitacion seleccionarPorNumero(String numero); 

}
