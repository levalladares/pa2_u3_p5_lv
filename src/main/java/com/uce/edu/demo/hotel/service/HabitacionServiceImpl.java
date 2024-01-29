package com.uce.edu.demo.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.hotel.repository.IHabitacionRepository;
import com.uce.edu.demo.hotel.repository.modelo.Habitacion;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	IHabitacionRepository habitacionRepository;
	
	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.insertar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminar(id);
	}

	@Override
	public Hotel buscarPClase(String clase) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPClase(clase);
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorNumero(numero);
	}

}
