package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ReporteDao;
import pe.edu.upc.entities.Reporte;

public class ReporteImpl implements ReporteDao {
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;
	
	@Transactional
	@Override
	public void insert(Reporte re) {
		try {
			op.persist(re);
		} catch (Exception e) {
			System.out.println("Error al insertar Reporte en DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reporte> list() {
		List<Reporte> listaReporte = new ArrayList<Reporte>();
		try {
			Query jpql = op.createQuery("from Reporte re");
			listaReporte = (List<Reporte>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de reporte");
		}
		
		return listaReporte;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			Reporte re = op.find(Reporte.class, id);
			op.remove(re);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
		
	}

}
