package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Cliente;
import pe.edu.upc.entities.Servicio;
import pe.edu.upc.serviceinterfaces.lClienteService;

@Named
@RequestScoped
public class ClienteController {
	@Inject
	private lClienteService cService;

	private Cliente co;
	List<Cliente> listaClientes;

	@PostConstruct
	public void init() {
		this.listaClientes = new ArrayList<Cliente>();
		this.co = new Cliente();
		this.list();
	}

	public String newCliente() {
		this.setCo(new Cliente());
		return "Cliente.xhtml";
	}

	public void insert() {
		try {
			cService.insert(co);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de clientes al insertar");
		}
	}

	public void list() {
		try {
			listaClientes = cService.list();
		} catch (Exception e) {
			System.out.println("Error al listar clientes en el controller!!");
		}
	}
	
	public void delete(Servicio ser) {
		try {
			cService.delete(ser.getIdServicio());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controlador de servicio");
		}
	}
	

	public Cliente getCo() {
		return co;
	}

	public void setCo(Cliente co) {
		this.co = co;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	
}
