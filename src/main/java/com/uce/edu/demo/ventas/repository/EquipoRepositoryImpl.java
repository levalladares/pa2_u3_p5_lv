package com.uce.edu.demo.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Equipo;
import com.uce.edu.demo.ventas.repository.modelo.Jugador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EquipoRepositoryImpl implements IEquipoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Equipo> seleccionarInnerJoin() {
		String jpql = "SELECT e FROM Equipo e INNER JOIN e.jugadores ju";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		List<Equipo> a = myQuery.getResultList();
		for(Equipo e : a) {
			e.getJugadores().size();
		}
		return a;
	}

	@Override
	public List<Jugador> seleccionarJugadoresInnerJoin() {
		String jpql = "SELECT ju FROM Equipo e INNER JOIN e.jugadores ju";
		TypedQuery<Jugador> myQuery = this.entityManager.createQuery(jpql, Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarRigthJoin() {
		String jpql = "SELECT e FROM Equipo e RIGHT JOIN e.jugadores ju";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		List<Equipo> a = myQuery.getResultList();
		for(Equipo e : a) {
			e.getJugadores().size();
		}
		return a;
	}

	@Override
	public List<Jugador> seleccionarJugadoresRigthJoin() {
		String jpql = "SELECT ju FROM Equipo e RIGHT JOIN e.jugadores ju";
		TypedQuery<Jugador> myQuery = this.entityManager.createQuery(jpql, Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarLeftJoin() {
		String jpql = "SELECT e FROM Equipo e LEFT JOIN e.jugadores ju";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		List<Equipo> a = myQuery.getResultList();
		for(Equipo e : a) {
			e.getJugadores().size();
		}
		return a;
	}

	@Override
	public List<Jugador> seleccionarJugadoresLeftJoin() {
		String jpql = "SELECT ju FROM Equipo e LEFT JOIN e.jugadores ju";
		TypedQuery<Jugador> myQuery = this.entityManager.createQuery(jpql, Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarFullJoin() {
		String jpql = "SELECT e FROM Equipo e FULL JOIN e.jugadores ju";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		List<Equipo> a = myQuery.getResultList();
		for(Equipo e : a) {
			e.getJugadores().size();
		}
		return a;
	}

	@Override
	public List<Jugador> seleccionarJugadoresFullJoin() {
		String jpql = "SELECT ju FROM Equipo e FULL JOIN e.jugadores ju";
		TypedQuery<Jugador> myQuery = this.entityManager.createQuery(jpql, Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarWhereJoin() {
		String jpql = "SELECT e FROM Equipo e, Jugador ju WHERE e=ju.equipo";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		List<Equipo> a = myQuery.getResultList();
		for(Equipo e : a) {
			e.getJugadores().size();
		}
		return a;
	}

	@Override
	public List<Jugador> seleccionarJugadoresWhereJoin() {
		String jpql = "SELECT ju FROM Equipo e, Jugador ju WHERE e=ju.equipo";
		TypedQuery<Jugador> myQuery = this.entityManager.createQuery(jpql, Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarFetchJoin() {
		String jpql = "SELECT e FROM Equipo e JOIN FETCH e.jugadores ju";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarJugadoresFetchJoin() {
		String jpql = "SELECT e FROM Equipo e JOIN FETCH e.jugadores ju WHERE ju.salario > 1000";
		TypedQuery<Equipo> myQuery = this.entityManager.createQuery(jpql, Equipo.class);
		return myQuery.getResultList();
	}

}
