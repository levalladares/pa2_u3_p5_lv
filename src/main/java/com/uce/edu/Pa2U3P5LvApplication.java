package com.uce.edu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
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
//		Factura f1 = new Factura();
//		f1.setCedula("12345");
//		f1.setFecha(LocalDate.now());
//		f1.setNumero("001-025");
//		
//		
//		
//		DetalleFactura det1 = new DetalleFactura();
//		det1.setCantidad(4);
//		det1.setCodigoBarras("544548454");
//		det1.setFactura(f1);
//		det1.setNombreProducto("cocaCola");
//		
//		DetalleFactura det2 = new DetalleFactura();
//		det2.setCantidad(2);
//		det2.setCodigoBarras("5457874872");
//		det2.setFactura(f1);
//		det2.setNombreProducto("Leche vita");
//		List<DetalleFactura> detalle= new ArrayList<>();
//		detalle.add(det1);
//		detalle.add(det2);
//		
//		f1.setDetalleFactura(detalle);
//	
		//this.facturaService.guardar(f1);
		
		Factura factura = this.facturaService.buscarPorNumero("001-025");
		for(DetalleFactura detalleFactura : factura.getDetalleFactura()) {
			System.out.println(detalleFactura);
		}
		System.out.println(factura);
		
	}

}
