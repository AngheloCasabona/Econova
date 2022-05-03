package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ClienteDao;
import pe.edu.upc.entities.Cliente;


public class ClienteImpl implements ClienteDao{
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;

	@Transactional
	@Override
	public void insert(Cliente cli) {
		// TODO Auto-generated method stub
		try {
			op.persist(cli);
		} catch (Exception e) {
			System.out.println("Error al insertar Cliente en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> list() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {
			Query jpql = op.createQuery("from Cliente cli");
			listaCliente = (List<Cliente>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de cliente");
		}
		
		return listaCliente;
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Cliente cli = op.find(Cliente.class, id);
			op.remove(cli);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}
		
	}
	
	@Transactional
	@Override
	public void update(Cliente cli) {
		try {
			op.merge(cli);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de cliente");
		}
		
	}
	
}

