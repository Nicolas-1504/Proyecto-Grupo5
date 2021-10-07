package com.edu.unbosque.ciclo3backGrupo7.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id
	private Long codigo_producto;
	private Double ivacompra;
	private Long nitproveedor;
	private String nombre_producto;
	private Double precio_compra;
	private Double precio_venta;

	public Producto() {
		
	}
	
	public Producto(Double ivacompra, Long nitproveedor, String nombre_producto,Double precio_compra, Double precio_venta) {
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	
	public Producto(Long codigo_producto, Double ivacompra, Long nitproveedor, String nombre_producto,Double precio_compra, Double precio_venta) {
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	
	public Long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public Double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public Long getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(Long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public Double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public Double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}
}
