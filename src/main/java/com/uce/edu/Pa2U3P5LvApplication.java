package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.service.IClienteService;
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

//		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
//		long tiempoInicial= System.currentTimeMillis();
//		for (int i = 1; i <= 10; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			this.clienteService.guardar(cliente);
//		}
//		long tiempoFinal= System.currentTimeMillis();
//
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		System.out.println("tiempo transcurrido EN SEG: "+ tiempoTranscurrido);
		//tiempo transcurrido EN SEG: 101
		
		
		
		//Programacion en paralelo (multihilo - multithread)
//		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
//		long tiempoInicial= System.currentTimeMillis();
//
//		List<Cliente> listaClientes = new ArrayList<>();
//		
//		for (int i = 1; i <= 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaClientes.add(cliente);
//		}
//		listaClientes.stream().forEach(cliente -> this.clienteService.guardar(cliente));
//		long tiempoFinal= System.currentTimeMillis();
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		System.out.println("tiempo transcurrido EN SEG: "+ tiempoTranscurrido);
		//tiempo transcurrido EN SEG: 101
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		long tiempoInicial= System.currentTimeMillis();

		List<Cliente> listaClientes = new ArrayList<>();
		
		for (int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listaClientes.add(cliente);
		}
		listaClientes.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
		long tiempoFinal= System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("tiempo transcurrido EN SEG: "+ tiempoTranscurrido);

		
		
		
		
		
		
		
	}

}
