package com.uce.edu.demo.ventas.repository;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Equipo;
import com.uce.edu.demo.ventas.repository.modelo.Jugador;

public interface IEquipoRepository {

	public List<Equipo> seleccionarInnerJoin();

	public List<Jugador> seleccionarJugadoresInnerJoin();

	public List<Equipo> seleccionarRigthJoin();

	public List<Jugador> seleccionarJugadoresRigthJoin();

	public List<Equipo> seleccionarLeftJoin();

	public List<Jugador> seleccionarJugadoresLeftJoin();

	public List<Equipo> seleccionarFullJoin();

	public List<Jugador> seleccionarJugadoresFullJoin();

	public List<Equipo> seleccionarWhereJoin();

	public List<Jugador> seleccionarJugadoresWhereJoin();

	public List<Equipo> seleccionarFetchJoin();

	public List<Equipo> seleccionarJugadoresFetchJoin();
}
