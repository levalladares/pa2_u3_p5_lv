package com.uce.edu.demo.ventas.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ventas.repository.IClienteRepository;
import com.uce.edu.demo.ventas.repository.IFacturaRepository;
import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IClienteService clienteService;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		BigDecimal valor= new BigDecimal(100);
		valor= valor.multiply(new BigDecimal(0.12));
		factura.setValorIVA(valor);
		
		System.out.println(org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaRepository.insertar(factura);
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasFetchJoin();
	}

	@Override
	public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual) {
		// TODO Auto-generated method stub
		return this.facturaRepository.actualizarFechas(fechaNueva, fechaActual);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasDTO();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("este metodo es de prueba");
		System.out.println("Prueba: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override

	public void pruebaSupport() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaNever();
	}
	
	
	
}
