package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Conductor;

public interface IConductorService {

	public void insert(Conductor p);
	public List<Conductor> list();
	public void delete(int id);
}
 
