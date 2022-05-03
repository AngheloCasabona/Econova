package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entities.EstadoInventario;
import pe.edu.upc.daointerfaces.EstadoInventarioDao;

public class EstadoInventarioImpl implements EstadoInventarioDao {
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;
	
	
	
	@Transactional
	@Override
	public void insert(EstadoInventario estd) {
		try {
			op.persist(estd);
		} catch (Exception e) {
			System.out.println("Error al insertar estadoinventario en DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoInventario> list() {
		List<EstadoInventario> listaEstadoInventario = new ArrayList<EstadoInventario>();
		try {
			Query jpql= op.createQuery("from EstadoInventario estd");
			listaEstadoInventario = (List<EstadoInventario>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de EstadoInventario");
		}
		return listaEstadoInventario;
	}

	@Transactional
	@Override
	public void delete(int id) {
		try {
			EstadoInventario estd = op.find(EstadoInventario.class, id);
			op.remove(estd);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
		
	}
	
	
	@Transactional
	@Override
	public void update(EstadoInventario estd) {
		// TODO Auto-generated method stub
		try {
			op.merge(estd);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de estadoInventario");
		}
	}

}
