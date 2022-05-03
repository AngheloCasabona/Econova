
package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.DetalleFacturaDao;
import pe.edu.upc.entities.DetalleFactura;

public class DetalleFacturaImpl implements DetalleFacturaDao{
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;
	
	@Transactional
	@Override
	public void insert(DetalleFactura p) {
	 	try {
			op.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar DetalleFactura en DAO");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleFactura> list() {
		List<DetalleFactura> listaDetalleFactura= new ArrayList<DetalleFactura>();
		try {
			Query jpql = op.createQuery("from DetalleFactura d");
			listaDetalleFactura = (List<DetalleFactura>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de DetalleFactura");
		}
		return listaDetalleFactura;
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			DetalleFactura Det = op.find(DetalleFactura.class, id);
			op.remove(Det);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
	}

}
