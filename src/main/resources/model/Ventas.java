package model;
// Generated 10 ene 2024 18:09:09 by Hibernate Tools 6.3.1.Final

import model.Clientes;
import model.Juegos;
import java.sql.Date;

/**
 * Ventas generated by hbm2java
 */
public class Ventas implements java.io.Serializable {

	private Integer idVenta;
	private Juegos juegos;
	private Clientes clientes;
	private double precioVenta;
	private Date fechaVenta;

	public Ventas() {
	}

	public Ventas(Juegos juegos, Clientes clientes, double precioVenta, Date fechaVenta) {
		this.juegos = juegos;
		this.clientes = clientes;
		this.precioVenta = precioVenta;
		this.fechaVenta = fechaVenta;
	}

	public Integer getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Juegos getJuegos() {
		return this.juegos;
	}

	public void setJuegos(Juegos juegos) {
		this.juegos = juegos;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
