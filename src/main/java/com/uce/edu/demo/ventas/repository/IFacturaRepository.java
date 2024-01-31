package com.uce.edu.demo.ventas.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	
	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	
	public List<Factura> seleccionarInnerJoin();
	
	public List<Factura> seleccionarFacturasRightJoin();
	
	public List<Factura> seleccionarFacturasLeftJoin();
	
	public List<Factura> seleccionarFacturasFullJoin();
	
	public List<Factura> seleccionarFacturasWhereJoin();
	
	public List<Factura> seleccionarFacturasFetchJoin();
	
	public List<FacturaDTO> seleccionarFacturasDTO();
	
	public void actualizar (Factura factura);
	
	public void eliminar (Integer id);
	
	public int eliminarPorNumero(String numero);
	
	public int actualizarFechas (LocalDate fechaNueva, LocalDate fechaActual);
	
	

}
