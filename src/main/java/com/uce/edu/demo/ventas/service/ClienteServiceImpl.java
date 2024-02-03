package com.uce.edu.demo.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println();
		this.clienteRepository.insertar(cliente);
	}

}
