package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.EstadoInventario;
import pe.edu.upc.serviceinterfaces.IEstadoInventarioService;

@Named
@RequestScoped
public class EstadoInventarioController {
	@Inject
	private IEstadoInventarioService estService;
	
	private EstadoInventario estd;
	List<EstadoInventario> listaEstadoInventarios;
	
	@PostConstruct
	public void init() {
		this.listaEstadoInventarios = new ArrayList<EstadoInventario>();
		this.estd = new EstadoInventario();
		this.list();	
	}
	
	public String newEstadoInventario() {

		this.setEstd(new EstadoInventario());
		return "EstadoInventario.xhtml";
	}

	public void insert() {
		try {
			estService.insert(estd);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de EstadoInventario");
		}
	}

	public void list() {
		try {
			listaEstadoInventarios = estService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller EstadoInventario");
		}
	}

	public void delete(EstadoInventario estd) {
		try {
			estService.delete(estd.getIdEstadoInventario());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller EstadoInventario");
		}
	}

	public EstadoInventario getEstd() {
		return estd;
	}

	public void setEstd(EstadoInventario estd) {
		this.estd = estd;
	}

	public List<EstadoInventario> getListaEstadoInventarios() {
		return listaEstadoInventarios;
	}

	public void setListaEstadoInventarios(List<EstadoInventario> listaEstadoInventarios) {
		this.listaEstadoInventarios = listaEstadoInventarios;
	}
	
	
	
	
}
