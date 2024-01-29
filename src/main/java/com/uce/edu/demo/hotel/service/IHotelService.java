package com.uce.edu.demo.hotel.service;

import java.util.List;

import com.uce.edu.demo.hotel.repository.modelo.Hotel;

public interface IHotelService {

	public void crear (Hotel hotel);
	public void actualizar(Hotel hotel);
	public void eliminar(Integer id);
	public Hotel buscar (Integer id);
	
	public Hotel buscarHotelPorDireccionNQ(String direccion);
	public List<Hotel> buscarHotelesPorNombre(String nombre);
	public List<Hotel> buscarHotelesPorEstado(String estado);
	public List<Hotel> buscarHotelesConHabitacionesConstruidas(String estado);
	public List<Hotel> buscarHoteles();
	
}
