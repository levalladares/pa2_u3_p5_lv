package com.uce.edu.demo.ventas.service;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Equipo;
import com.uce.edu.demo.ventas.repository.modelo.Jugador;

public interface IEquipoService {

	public List<Equipo> buscarInnerJoin();

	public List<Jugador> buscarJugadoresInnerJoin();

	public List<Equipo> buscarRigthJoin();

	public List<Jugador> buscarJugadoresRigthJoin();

	public List<Equipo> buscarLeftJoin();

	public List<Jugador> buscarJugadoresLeftJoin();

	public List<Equipo> buscarFullJoin();

	public List<Jugador> buscarJugadoresFullJoin();

	public List<Equipo> buscarWhereJoin();

	public List<Jugador> buscarJugadoresWhereJoin();

	public List<Equipo> buscarFetchJoin();

	public List<Equipo> buscarJugadoresFetchJoin();

}
