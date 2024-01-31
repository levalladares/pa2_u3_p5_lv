package com.uce.edu;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.demo.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5LvApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UPDATE");
		int cantidadActu =this.facturaService.actualizarFechas(LocalDate.of(2020, 01, 15), LocalDate.of(2024, 01, 25));
		System.out.println("cantidad de registros actualizados: "+cantidadActu);
		
		System.out.println("DELETE");
		int cantidadElim = this.facturaService.borrarPorNumero("04-45852");
		System.out.println("cantidad de registros/filas eliminados: "+ cantidadElim);
		
		System.out.println("DTO");
		List<FacturaDTO> listaDTO = this.facturaService.buscarFacturasDTO();
		for(FacturaDTO f : listaDTO) {
			System.out.println(f);
		}

	}

}
