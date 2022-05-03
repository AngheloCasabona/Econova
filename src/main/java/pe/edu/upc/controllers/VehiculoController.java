package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.entities.Conductor;
import pe.edu.upc.serviceinterfaces.IVehiculoService;
import pe.edu.upc.daoimpls.ConductorImpl;

@Named
@RequestScoped
public class VehiculoController {
	@Inject
	private IVehiculoService vService;
	@Inject
	private ConductorImpl cService;
	
	
	private Vehiculo v;
	List<Vehiculo> listaVehiculos;
	List<Conductor> listaConductor;

	@PostConstruct
	public void init() {
		this.listaVehiculos = new ArrayList<Vehiculo>();
		this.listaConductor= new ArrayList<Conductor>();
		this.v = new Vehiculo();
		this.listaConductor();
		this.list();
	}

	private void listaConductor() {
		try {
			listaConductor =cService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  conductor en el controlador de vehiculo");
		}
	}

	public String newVehiculo() {
		this.setV(new Vehiculo());
		return "Vehiculo.xhtml";
	}

	public void insert() {
		try {
			vService.insert(v);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de vehiculo al insertar");
		}
	}

	public void list() {
		try {
			listaVehiculos = vService.list();
		} catch (Exception e) {
			System.out.println("Error al listar vehiculos en el controller!!");
		}
	}


	public Vehiculo getV() {
		return v;
	}

	public void setV(Vehiculo v) {
		this.v = v;
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public List<Conductor> getListaConductor() {
		return listaConductor;
	}

	public void setListaConductor(List<Conductor> listaConductor) {
		this.listaConductor = listaConductor;
	}
	
	

}
