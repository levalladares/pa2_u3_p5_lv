package com.uce.edu.demo.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ventas.repository.IEquipoRepository;
import com.uce.edu.demo.ventas.repository.modelo.Equipo;
import com.uce.edu.demo.ventas.repository.modelo.Jugador;

@Service
public class EquipoServiceImpl implements IEquipoService {
	@Autowired
	private IEquipoRepository equipoRepository;

	@Override
	public List<Equipo> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresInnerJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresInnerJoin();
	}

	@Override
	public List<Equipo> buscarRigthJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarRigthJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresRigthJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresRigthJoin();
	}

	@Override
	public List<Equipo> buscarLeftJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarLeftJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresLeftJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresLeftJoin();
	}

	@Override
	public List<Equipo> buscarFullJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarFullJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresFullJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresFullJoin();
	}

	@Override
	public List<Equipo> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresWhereJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresWhereJoin();
	}

	@Override
	public List<Equipo> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarFetchJoin();
	}

	@Override
	public List<Equipo> buscarJugadoresFetchJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresFetchJoin();
	}

}
