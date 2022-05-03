package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.EmpresaDao;
import pe.edu.upc.entities.Empresa;

public class EmpresaImpl implements EmpresaDao {
	@PersistenceContext(unitName = "TBEconova")
	private EntityManager op;

	@Transactional
	@Override
	public void insert(Empresa emp) {
		try {
			op.persist(emp);
		} catch (Exception e) {
			System.out.println("Error al insertar empresa en DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> list() {
		List<Empresa> listaEmpresa = new ArrayList<Empresa>();
		try {
			Query jpql = op.createQuery("from Empresa emp");
			listaEmpresa = (List<Empresa>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el DAO de servicio");
		}

		return listaEmpresa;
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Empresa emp = op.find(Empresa.class, id);
			op.remove(emp);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el DAO");
		}

	}

	@Transactional
	@Override
	public void update(Empresa emp) {
		try {
			op.merge(emp);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de empresa");
		}
	}

}
