package pe.edu.upc.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entities.Empresa;
import pe.edu.upc.entities.Reporte;
import pe.edu.upc.entities.Servicio;
import pe.edu.upc.entities.Vehiculo;
import pe.edu.upc.daointerfaces.ServicioDao;
import pe.edu.upc.serviceinterfaces.IVehiculoService;
import pe.edu.upc.serviceinterfaces.IEmpresaService;
import pe.edu.upc.serviceinterfaces.lReporteService;


@Named
@RequestScoped
public class ReporteController {

	@Inject
	private lReporteService reService;
	@Inject
	private IEmpresaService emService;
	@Inject
	private IVehiculoService veService;
	@Inject
	private ServicioDao servService;
	
	private Reporte Re;
	private List<Reporte> listaReportes;
	private List<Empresa> listaEmpresas;
	private List<Vehiculo> listaVehiculos;
	private List<Servicio> listaServicios;
	
	@PostConstruct
	public void init() {
		this.Re = new Reporte();
		this.listaReportes = new ArrayList<Reporte>();
		this.listaEmpresas = new ArrayList<Empresa>();
		this.listaVehiculos = new ArrayList<Vehiculo>();
		this.listaServicios = new ArrayList<Servicio>();
		this.listaEmpresas();
		this.listaVehiculos();
		this.listaServicios();
		this.list();
	}
	
	public String newReporte() {
		this.setRe(new Reporte());
		return "Reporte.xhtml";
	}
	
	public void insert() {
		try {
			reService.insert(Re);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de reporte");
		}
	}

	public void list() {
		try {
			listaReportes = reService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de reporte");
		}
	}

	public void listaEmpresas() {
		try {
			listaEmpresas = emService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  Empresas en el controlador de Reporte");
		}
	}

	public void listaVehiculos() {
		try {
			listaVehiculos = veService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Vehiculos en el controlador de Reporte");
		}
	}
	
	public void listaServicios() {
		try {
			listaServicios = servService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Servicios en el controlador de Reporte");
		}
	}


	public Reporte getRe() {
		return Re;
	}

	public void setRe(Reporte re) {
		Re = re;
	}

	public List<Reporte> getListaReportes() {
		return listaReportes;
	}

	public void setListaReportes(List<Reporte> listaReportes) {
		this.listaReportes = listaReportes;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public List<Servicio> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	
}
