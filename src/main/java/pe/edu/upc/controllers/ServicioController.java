package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Servicio;
import pe.edu.upc.entities.Empresa;
import pe.edu.upc.serviceinterfaces.IEmpresaService;
import pe.edu.upc.serviceinterfaces.IServicioService;

@Named
@RequestScoped
public class ServicioController {
	@Inject
	private IServicioService rService;
	@Inject
	private IEmpresaService eService;

	private Servicio r;
	List<Servicio> listaServicios;
	List<Empresa> listaEmpresas;

	@PostConstruct
	public void init() {
		this.r = new Servicio();
		this.listaServicios = new ArrayList<Servicio>();
		this.listaEmpresas = new ArrayList<Empresa>();
		this.listaEmpresas();
		this.list();
	}

	public String newServicio() {
		this.setR(new Servicio());
		return "Servicio.xhtml";
	}

	public void insert() {
		try {
			rService.insert(r);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de Servicio al insertar");
		}
	}

	public void list() {
		try {
			listaServicios = rService.list();
		} catch (Exception e) {
			System.out.println("Error al listar servicio en el controlador!!");
		}
	}

	public void delete(Servicio ser) {
		try {
			rService.delete(ser.getIdServicio());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de servicio");
		}
	}
	
	private void listaEmpresas() {
		try {
			listaEmpresas = eService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  empresas en el controlador de servicio");
		}
	}
	

	public Servicio getR() {
		return r;
	}

	public void setR(Servicio r) {
		this.r = r;
	}

	public List<Servicio> getListaServicio() {
		return listaServicios;
	}

	public void setListaServicio(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

}
