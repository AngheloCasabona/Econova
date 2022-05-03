package pe.edu.upc.daoimpls;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.DetalleSeguimientoDao;
import pe.edu.upc.entities.DetalleSeguimiento;

public class DetalleSeguimientoImpl implements DetalleSeguimientoDao{

	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;
	
	@Transactional
	@Override
	public void insert(DetalleSeguimiento det) {
		try {
			op.persist(det);
		} catch (Exception e) {
			System.out.println("Error al insertar detalleseguimiento en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleSeguimiento> list() {
		List<DetalleSeguimiento> listaDetalleSeguimientos = new ArrayList<DetalleSeguimiento>();
		try {
			Query jpql = op.createQuery("from DetalleSeguimiento de");
			listaDetalleSeguimientos = (List<DetalleSeguimiento>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el dao de vacunación");
		}
		return listaDetalleSeguimientos;
	}

	@Override
	public void delete(int id) {
		try {
			DetalleSeguimiento de = op.find(DetalleSeguimiento.class, id);
			op.remove(de);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
	}

	@Override
	public void update(DetalleSeguimiento det) {
		try {
			op.merge(det);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de detalleseguimiento");
		}
	}
	
	

}
