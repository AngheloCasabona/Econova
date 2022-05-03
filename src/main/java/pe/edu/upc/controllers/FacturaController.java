package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Factura;
import pe.edu.upc.entities.Cliente;
import pe.edu.upc.entities.Servicio;
import pe.edu.upc.serviceinterfaces.IFacturaService;
import pe.edu.upc.daoimpls.ClienteImpl;
import pe.edu.upc.daoimpls.ServicioImpl;

@Named
@RequestScoped
public class FacturaController {
	@Inject
	private IFacturaService fService;
	@Inject
	private ClienteImpl cService;
	@Inject
	private ServicioImpl seService;
	
	
	private Factura f;
	List<Factura> listaFacturas;
	List<Cliente> listaClientes;
	List<Servicio> listaServicios;
	
	@PostConstruct
	public void init() {
		this.f = new Factura();
		this.listaFacturas = new ArrayList<Factura>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaServicios = new ArrayList<Servicio>();
		this.listaClientes();
		this.listaServicios();
		this.list();
	}
	
	private void listaServicios() {
		
		try {
			listaServicios = seService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  Servicios en el controlador de Factura");
		}
	}

	private void listaClientes() {
		try {
			listaClientes = cService.list();
		} catch (Exception e) {
			System.out.println("Error al listar  Clientes en el controlador de Factura");
		}
		
	}

	public String newFactura() {
		this.setF(new Factura());
		return "Factura.xhtml";
	}

	public void insert() {
		try {
			fService.insert(f);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de Factura al insertar");
		}
	}
	
	public void list() {
		try {
			listaFacturas = fService.list();
		} catch (Exception e) {
			System.out.println("Error al listar facturas en el controller!!");
		}
	}

	
	public Factura getF() {
		return f;
	}

	public void setF(Factura f) {
		this.f = f;
	}

	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Servicio> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	
	
	
	
}
