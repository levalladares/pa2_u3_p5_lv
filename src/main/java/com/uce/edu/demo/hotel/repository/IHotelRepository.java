package com.uce.edu.demo.hotel.repository;

import java.util.List;

import com.uce.edu.demo.hotel.repository.modelo.Hotel;

public interface IHotelRepository {

	public Hotel seleccionar (Integer id);
	public void insertar (Hotel hotel);
	public void actualizar(Hotel hotel);
	public void eliminar(Integer id);
	
	public Hotel seleccionarHotelPorDireccionNQ(String direccion);
	
	public List<Hotel> seleccionarHotelesInnerJoin(String nombre);
	
	public List<Hotel> seleccionarHotelesLeftJoin(String estado);
	
	public List<Hotel> seleccionarHotelesRightJoinPorEstado(String estado);
	
	public List<Hotel> seleccionarHotelesFull();

}
