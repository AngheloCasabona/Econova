
package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.DetalleFacturaDao;
import pe.edu.upc.entities.DetalleFactura;
import pe.edu.upc.serviceinterfaces.IDetalleFacturaService;

@Named
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{

	@Inject
	private DetalleFacturaDao dDao;
	
	@Override
	public void insert(DetalleFactura d) {
		dDao.insert(d);
		
	}

	@Override
	public List<DetalleFactura> list() {
		return dDao.list();
	}

	@Override
	public void delete(int id) {
		dDao.delete(id);
	}

}
