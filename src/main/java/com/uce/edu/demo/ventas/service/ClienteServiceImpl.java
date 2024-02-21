package com.uce.edu.demo.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ventas.repository.IClienteRepository;
import com.uce.edu.demo.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	@Async 		//PARA PROGRAMACION ASINCRONA
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		this.clienteRepository.insertar(cliente);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo supports");
		System.out.println("Prueba supports"+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo never");
		System.out.println("Prueba never: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());

	}

}
