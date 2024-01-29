package com.uce.edu.demo.hotel.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.hotel.repository.modelo.Habitacion;
import com.uce.edu.demo.hotel.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HabitacionRepositoryImpl implements IHabitacionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion h = this.seleccionar(id);
		this.entityManager.remove(h);
		
	}

	@Override
	public Hotel seleccionarPClase(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones hab WHERE hab.clase = :clase", Hotel.class);
		myQuery.setParameter("clase", clase);
		return myQuery.getSingleResult();
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM habitacion h WHERE h.habi_numero = :numero", Habitacion.class);
		myQuery.setParameter("numero", numero);
		return (Habitacion) myQuery.getSingleResult();
	}

}
