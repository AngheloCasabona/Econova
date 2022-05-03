package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.DetalleFactura;
import pe.edu.upc.entities.Factura;
import pe.edu.upc.serviceinterfaces.IDetalleFacturaService;
import pe.edu.upc.serviceinterfaces.IFacturaService;

@Named
@RequestScoped
public class DetalleFacturaController {
	@Inject
	private IDetalleFacturaService dService;
	@Inject
	private IFacturaService fService;

	private DetalleFactura d;
	List<DetalleFactura> listaDetalleFacturas;
	List<Factura> listaFacturas;

	@PostConstruct
	public void init() {
		this.d = new DetalleFactura();
		this.listaDetalleFacturas = new ArrayList<DetalleFactura>();
		this.listaFacturas = new ArrayList<Factura>();
		this.listaFacturas();
		this.list();
	}

	public String newDetalleFactura() {
		this.setD(new DetalleFactura());
		return "DetalleFactura.xhtml";
	}

	public void insert() {
		try {
			dService.insert(d);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de DetalleFactura al insertar");
		}
	}

	public void list() {
		try {
			listaDetalleFacturas = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar DetalleFacturas en el controller!!");
		}
	}
	
	public void listaFacturas() {
		try {
			fService.list();
		} catch (Exception e) {
			System.out.println("Error al listar vacunas en el controlador de DetalleFactura ");
		}
	}
	
	public DetalleFactura getD() {
		return d;
	}

	public void setD(DetalleFactura d) {
		this.d = d;
	}

	public List<DetalleFactura> getListaDetalleFactura() {
		return listaDetalleFacturas;
	}

	public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFacturas) {
		this.listaDetalleFacturas = listaDetalleFacturas;
	}
	
	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	

}
