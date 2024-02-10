package com.uce.edu;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.service.IClienteService;
import com.uce.edu.demo.ventas.service.IEquipoService;
import com.uce.edu.demo.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5LvApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5LvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//this.facturaService.pruebaSupport();
		//this.facturaService.pruebaNever();
	}

}
