package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Cliente;

public interface ClienteDao {
	public void insert(Cliente cli);
	public List<Cliente> list();
	public void delete(int id);
	public void update(Cliente cli);
}
