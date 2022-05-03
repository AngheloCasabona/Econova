package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Vehiculo;

public interface VehiculoDao {
	public void insert(Vehiculo p);
	public List<Vehiculo> list();
	public void delete(int id);
}

