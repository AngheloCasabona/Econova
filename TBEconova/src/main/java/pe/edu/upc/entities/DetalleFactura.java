
package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalle;
	@Column(name = "nombreDetalle",nullable = false,length = 30)
	private String nombreDetalle;
	@Column(name = "cantidadDetalle",nullable = false)
	private int cantidadDetalle;
	@Column(name = "fechaDetalle",nullable = false)
	private Date fechaDetalle;
	@Column(name = "precioDetalle",nullable = false)
	private double precioDetalle;
	@Column(name = "CostoTotal",nullable = false)
	private double CostoTotal;

	public DetalleFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleFactura(int idDetalle, String nombreDetalle, int cantidadDetalle, Date fechaDetalle, double precioDetalle,
			double costoTotal) {
		super();
		this.idDetalle = idDetalle;
		this.nombreDetalle = nombreDetalle;
		this.cantidadDetalle = cantidadDetalle;
		this.fechaDetalle = fechaDetalle;
		this.precioDetalle = precioDetalle;
		CostoTotal = costoTotal;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getNombreDetalle() {
		return nombreDetalle;
	}

	public void setNombreDetalle(String nombreDetalle) {
		this.nombreDetalle = nombreDetalle;
	}

	public int getCantidadDetalle() {
		return cantidadDetalle;
	}

	public void setCantidadDetalle(int cantidadDetalle) {
		this.cantidadDetalle = cantidadDetalle;
	}

	public Date getFechaDetalle() {
		return fechaDetalle;
	}

	public void setFechaDetalle(Date fechaDetalle) {
		this.fechaDetalle = fechaDetalle;
	}

	public double getPrecioDetalle() {
		return precioDetalle;
	}

	public void setPrecioDetalle(double precioDetalle) {
		this.precioDetalle = precioDetalle;
	}

	public double getCostoTotal() {
		return CostoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		CostoTotal = costoTotal;
	}

}
