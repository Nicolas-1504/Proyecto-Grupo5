package com.edu.unbosque.ciclo3backGrupo7.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_ventas")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo_detalle_venta;
	private Long cantidad_producto;
	private Long codigo_producto;
	private Long codigo_venta;
	private Double valor_total;
	private Double valor_venta;
	private Double ivacompra;
	
	public DetalleVenta() {
		
	}
	
	public DetalleVenta(Long cantidad_producto, Long codigo_producto, Long codigo_venta,Double valor_total, Double valor_venta, Double ivacompra) {
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.ivacompra = ivacompra;
	}
	
	public DetalleVenta(Long codigo_detalle_venta, Long cantidad_producto, Long codigo_producto, Long codigo_venta,Double valor_total, Double valor_venta, Double ivacompra) {
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.ivacompra = ivacompra;
	}
	
	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public Long getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(Long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public Long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}
}
