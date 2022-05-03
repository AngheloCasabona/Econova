package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.DetalleSeguimiento;
import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.serviceinterfaces.DetalleSeguimientoService;
import pe.edu.upc.serviceinterfaces.IVehiculoService;


@Named
@RequestScoped
public class DetalleSeguimientoController {
	@Inject
	private DetalleSeguimientoService dService;
	@Inject
	private IVehiculoService vService;

	private DetalleSeguimiento deta;
	List<DetalleSeguimiento> listadetalleSeguimientos;
	List<Vehiculo> listavehiculos;
	
	@PostConstruct
	public void init() {
		this.deta = new DetalleSeguimiento();
		this.listadetalleSeguimientos = new ArrayList<DetalleSeguimiento>();
		this.listavehiculos = new ArrayList<Vehiculo>();
		this.listavehiculos();
		this.list();
	}

	public String newDetalleServicio() {
		this.setDeta(new DetalleSeguimiento());
		return "DetalleSeguimiento.xhtml";
	}

	public void insert() {
		try {
			dService.insert(deta);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de detalleseguimiento al insertar");
		}
	}

	public void list() {
		try {
			listadetalleSeguimientos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar servicio en el controlador!!");
		}
	}

	public void delete(DetalleSeguimiento deta) {
		try {
			dService.delete(deta.getIdDetalleSeguimiento());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de detalleseguimiento");
		}
	}
	
	private void listavehiculos() {
		try {
			listavehiculos = vService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  vehiculos en el controlador de detalleseguimiento");
		}
	}

	public DetalleSeguimiento getDeta() {
		return deta;
	}

	public void setDeta(DetalleSeguimiento deta) {
		this.deta = deta;
	}

	public List<DetalleSeguimiento> getListadetalleSeguimientos() {
		return listadetalleSeguimientos;
	}

	public void setListadetalleSeguimientos(List<DetalleSeguimiento> listadetalleSeguimientos) {
		this.listadetalleSeguimientos = listadetalleSeguimientos;
	}

	public List<Vehiculo> getListavehiculos() {
		return listavehiculos;
	}

	public void setListavehiculos(List<Vehiculo> listavehiculos) {
		this.listavehiculos = listavehiculos;
	}
	
	
}
