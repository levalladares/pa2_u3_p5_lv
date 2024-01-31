package com.uce.edu.demo.ventas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		String jpql = "SELECT f FROM Factura f WHERE f.numero = : numero";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFactura().size(); // le digo que cargue el detalle bajo demanda 
		return fact;
		
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		//SQL: SELECT * FROM factura f INNER JOIN detalle_factura d on f.fact_id=d.defa_id_factura
		//JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d 
		String jpql="SELECT f FROM Factura f JOIN f.detalleFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for(Factura f : lista) {
//			f.getDetalleFactura().size();
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f LEFT JOIN f.detalleFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f FULL JOIN f.detalleFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		//jpql: SELECT f FROM Factura f, DetalleFactura d WHERE f= d.factura
		String jpql="SELECT f FROM Factura f, DetalleFactura d WHERE f= d.factura";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for(Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		String jpql="SELECT f FROM Factura f JOIN FETCH f.detalleFactura d";
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(jpql, Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}


	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		String jpql="DELETE FROM Factura f WHERE f.numero= :numero";
		Query myQuery = this.entityManager.createQuery(jpql);
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual) {
		// TODO Auto-generated method stub
		String jpql="UPDATE Factura f SET f.fecha= :fechaNueva WHERE f.fecha >= :fechaActual";
		Query myQuery = this.entityManager.createQuery(jpql);
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		return myQuery.executeUpdate();
		
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		String jpql="SELECT NEW com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f";
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery(jpql,FacturaDTO.class);
		return myQuery.getResultList();
	}


}
