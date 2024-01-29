package com.uce.edu.demo.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.hotel.repository.modelo.Hotel;
import com.uce.edu.demo.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel h = this.seleccionar(id);
		this.entityManager.remove(h);
	}

	@Override
	public Hotel seleccionarHotelPorDireccionNQ(String direccion) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM hotel h WHERE h.hote_direccion= :dato",
				Hotel.class);
		myQuery.setParameter("dato", direccion);
		return (Hotel) myQuery.getSingleResult();
		
		
	}

	@Override
	public List<Hotel> seleccionarHotelesInnerJoin(String nombre) {
		// TODO Auto-generated method stub
		String jpql="SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE h.nombre= :nombre";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, Hotel.class);
		myQuery.setParameter("nombre", nombre);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelesLeftJoin(String estado) {
		// TODO Auto-generated method stub
		String jpql="SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE h.estado= :estado";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, Hotel.class);
		myQuery.setParameter("estado", estado);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelesRightJoinPorEstado(String estado) {
		// TODO Auto-generated method stub
		String jpql="SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE h.estado= :estado";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, Hotel.class);
		myQuery.setParameter("estado", estado);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelesFull() {
		// TODO Auto-generated method stub
		String jpql="SELECT h FROM Hotel h FULL JOIN h.habitaciones ha";
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

}
