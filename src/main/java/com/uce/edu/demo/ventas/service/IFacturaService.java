package com.uce.edu.demo.ventas.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	
	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura, Cliente cliente);

	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturasRightJoin();
	public List<Factura> buscarFacturasLeftJoin();
	public List<Factura> buscarFacturasFullJoin();
	public List<Factura> buscarFacturasWhereJoin();
	public List<Factura> buscarFacturasFetchJoin();
	public int actualizarFechas (LocalDate fechaNueva, LocalDate fechaActual);
	public int borrarPorNumero(String numero);
	public List<FacturaDTO> buscarFacturasDTO();

	
}
