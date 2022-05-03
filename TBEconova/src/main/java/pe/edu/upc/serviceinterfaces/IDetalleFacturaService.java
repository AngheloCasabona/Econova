
package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.DetalleFactura;



public interface IDetalleFacturaService {
	public void insert(DetalleFactura d);
	public List<DetalleFactura> list();
	public void delete(int id);
}
