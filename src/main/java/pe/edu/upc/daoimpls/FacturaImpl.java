package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.FacturaDao;
import pe.edu.upc.entities.Factura;

public class FacturaImpl implements FacturaDao {
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;

	@Transactional
	@Override
	public void insert(Factura f) {
		try {
			op.persist(f);
		} catch (Exception e) {
			System.out.println("Error al insertar factura en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> list() {
		List<Factura> listaFactura = new ArrayList<Factura>();
		try {
			// JPQL
			Query jpql = op.createQuery("from Factura p");
			listaFactura = (List<Factura>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de factura");
		}
		return listaFactura;
	}

}
