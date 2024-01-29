package com.uce.edu.demo.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.hotel.repository.IHotelRepository;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;
	@Override
	public void crear(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.insertar(hotel);
	}
	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.hotelRepository.actualizar(hotel);
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.hotelRepository.eliminar(id);
	}
	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionar(id);
	}
	@Override
	public Hotel buscarHotelPorDireccionNQ(String direccion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelPorDireccionNQ(direccion);
	}
	@Override
	public List<Hotel> buscarHotelesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelesInnerJoin(nombre);
	}
	@Override
	public List<Hotel> buscarHotelesPorEstado(String estado) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelesLeftJoin(estado);
	}
	@Override
	public List<Hotel> buscarHotelesConHabitacionesConstruidas(String estado) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelesRightJoinPorEstado(estado);
	}
	@Override
	public List<Hotel> buscarHoteles() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHotelesFull();
	}

	
}
