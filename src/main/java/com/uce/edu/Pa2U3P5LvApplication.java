package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.Equipo;
import com.uce.edu.demo.ventas.repository.modelo.Jugador;
import com.uce.edu.demo.ventas.service.IEquipoService;

@SpringBootApplication
public class Pa2U3P5LvApplication implements CommandLineRunner {

	@Autowired
	private IEquipoService equipoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("INNER JOIN");
		List<Equipo> e1 = this.equipoService.buscarInnerJoin();
		for(Equipo e : e1) {
			System.out.println(e);
		}
		
		List<Jugador> j1 = this.equipoService.buscarJugadoresInnerJoin();
		for(Jugador j : j1) {
			System.out.println(j);
		}
		
		
		System.out.println("RIGHT JOIN");
		List<Equipo> e2 = this.equipoService.buscarRigthJoin();
		for(Equipo e : e2) {
			System.out.println(e);
		}
		
		List<Jugador> j2 = this.equipoService.buscarJugadoresRigthJoin();
		for(Jugador j : j2) {
			System.out.println(j);
		}
		
		System.out.println("LEFT JOIN");
		List<Equipo> e3 = this.equipoService.buscarLeftJoin();
		for(Equipo e : e3) {
			System.out.println(e);
		}
		
		List<Jugador> j3 = this.equipoService.buscarJugadoresLeftJoin();
		for(Jugador j : j3) {
			System.out.println(j);
		}
		
		System.out.println("FULL JOIN");
		List<Equipo> e4 = this.equipoService.buscarFullJoin();
		for(Equipo e : e4) {
			System.out.println(e);
		}
		
		List<Jugador> j4 = this.equipoService.buscarJugadoresFullJoin();
		for(Jugador j : j4) {
			System.out.println(j);
		}
		
		System.out.println("JOIN FETCH");
		List<Equipo> e5 = this.equipoService.buscarFetchJoin();
		for(Equipo e : e5) {
			System.out.println(e);
		}
		
		List<Equipo> j5 = this.equipoService.buscarJugadoresFetchJoin();
		for(Equipo j : j5) {
			System.out.println(j);
		}
		
		
		
		
		

	}

}
