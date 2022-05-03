package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ServicioDao;
import pe.edu.upc.entities.Servicio;

public class ServicioImpl implements ServicioDao {
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;

	
	@Transactional
	@Override
	public void insert(Servicio r) {
		try {
			op.persist(r);
		} catch (Exception e) {
			System.out.println("Error al insertar servicio en DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> list() {
		List<Servicio> listaRecojo = new ArrayList<Servicio>();
		try {
			Query jpql = op.createQuery("from Recojo r");
			listaRecojo = (List<Servicio>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de servicio");
		}
		
		return listaRecojo;
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Servicio rec = op.find(Servicio.class, id);
			op.remove(rec);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
		
	}

	@Transactional
	@Override
	public void update(Servicio ser) {
		// TODO Auto-generated method stub
		try {
			op.merge(ser);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de servicio");
		}
	}


	
}

