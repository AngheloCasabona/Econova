package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.EstadoInventario;
import pe.edu.upc.entities.Empresa;
import pe.edu.upc.serviceinterfaces.IEmpresaService;
import pe.edu.upc.serviceinterfaces.IEstadoInventarioService;

@Named
@RequestScoped
public class EmpresaController {
	@Inject
	private IEstadoInventarioService estService;
	@Inject
	private IEmpresaService eService;

	private Empresa est;
	List<EstadoInventario> listaEstadoInventario;
	List<Empresa> listaEmpresas;

	@PostConstruct
	public void init() {
		this.est = new Empresa();
		this.listaEstadoInventario = new ArrayList<EstadoInventario>();
		this.listaEmpresas = new ArrayList<Empresa>();
		this.listaEstadoInventario();
		this.list();
	}

	public String newEmpresa() {
		this.setEst(new Empresa());
		return "Empresa.xhtml";
	}

	public void insert() {
		try {
			eService.insert(est);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de Empresa al insertar");
		}
	}

	public void list() {
		try {
			listaEmpresas = eService.list();
		} catch (Exception e) {
			System.out.println("Error al listar empresas en el controlador!!");
		}
	}

	public void delete(Empresa est) {
		try {
			eService.delete(est.getIdEmpresa());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de empresa");
		}
	}
	
	private void listaEstadoInventario() {
		try {
			listaEstadoInventario = estService.list();
		} catch (Exception e) {
			System.out.println("Error al listar EstadoInventario en el controlador de empresas");
		}
	}
	
	public Empresa getEst() {
		return est;
	}

	public void setEst(Empresa est) {
		this.est = est;
	}

	public List<EstadoInventario> getListaEstadoInventario() {
		return listaEstadoInventario;
	}

	public void setListaEstadoInventario(List<EstadoInventario> listaEstadoInventario) {
		this.listaEstadoInventario = listaEstadoInventario;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}
	
}
	
	
