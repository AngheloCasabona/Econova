package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.VehiculoDao;
import pe.edu.upc.entities.Vehiculo;

public class VehiculoImpl implements VehiculoDao{
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;

	@Transactional
	@Override
	public void insert(Vehiculo v) {
		// TODO Auto-generated method stub
		try {
			op.persist(v);
		} catch (Exception e) {
			System.out.println("Error al insertar persona en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> list() {
		List<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
		try {
			// JPQL
			Query jpql = op.createQuery("from Vehiculo p");
			listaVehiculo = (List<Vehiculo>) jpql.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el DAO de persona");
		}

		// TODO Auto-generated method stub
		return listaVehiculo;
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			Vehiculo con = op.find(Vehiculo.class, id);
			op.remove(con);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
	}

	
	
	
}

