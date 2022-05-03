package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Conductor;
import pe.edu.upc.serviceinterfaces.IConductorService;

@Named
@RequestScoped
public class ConductorController {
	@Inject
	private IConductorService pService;

	private Conductor p;
	List<Conductor> listaConductores;

	@PostConstruct
	public void init() {
		this.listaConductores = new ArrayList<Conductor>();
		this.p = new Conductor();
		this.list();
	}

	public String newConductor() {
		this.setP(new Conductor());
		return "Conductor.xhtml";
	}

	public void insert() {
		try {
			pService.insert(p);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de persona al insertar");
		}
	}

	public void list() {
		try {
			listaConductores = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar personas en el controller!!");
		}
	}
	
<<<<<<< HEAD
=======
	public void delete(Conductor con) {
		try {
			pService.delete(con.getId());
			list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de persona" + e.getMessage());
		}
	}

>>>>>>> f8c744d8135b823deb81c1b57636437d684399ff
	public Conductor getP() {
		return p;
	}

	public void setP(Conductor p) {
		this.p = p;
	}

	public List<Conductor> getListaConductor() {
		return listaConductores;
	}

	public void setListaConductor(List<Conductor> listaConductores) {
		this.listaConductores = listaConductores;
	}

}
