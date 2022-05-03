package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.VehiculoDao;
import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.serviceinterfaces.IVehiculoService;

@Named
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Inject
	private VehiculoDao vDao;
	
	@Override
	public void insert(Vehiculo v) {
		vDao.insert(v);
	}

	@Override
	public List<Vehiculo> list() {
		return vDao.list();
	}
	
	@Override
	public void delete(int id) {
		vDao.delete(id);
	}

	

}

